package market.controller;

import market.config.AbstractConfigTest;
import market.dto.PasswordRequestDto;
import market.dto.SignInRequestDto;
import market.dto.SignUpRequestDto;
import market.utils.TestUtils;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@Sql(value = "/sql/authorization_controller_test_before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/sql/authorization_controller_test_after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class AuthorizationControllerTest extends AbstractConfigTest {

    private static final String SIGN_IN = "/api/auth/signIn";
    private static final String SIGN_UP = "/api/auth/signUp";

    @Test
    public void signInTest() throws Exception {

        String user1 = "user1_test@gmail.com";
        String user999 = "user999_test@gmail.com";
        SignInRequestDto signInRequestDto;

        // positive #1
        // проверяем успешный login (+ сравниваем ушедший email с пришедшим)
        signInRequestDto = new SignInRequestDto(user1, "Qwerty123");
        mockExecute(signInRequestDto, 200, "$.data.accountResponseDto.email", user1);

        // negative #1
        // проверяем на неправильный пароль
        signInRequestDto = new SignInRequestDto(user1, "qwerty123");
        mockExecute(signInRequestDto, 401, "$.message", "Authentication exception");

        // negative #2
        // проверяем на длину пароля (validation)
        signInRequestDto = new SignInRequestDto(user1, "1234");
        mockExecute(signInRequestDto, 400, "$.fields[0].message", "The 'password' must be greater than or equal to 8");

        // negative #3
        // проверяем на пустой/null email
        signInRequestDto = new SignInRequestDto(null, "Qwerty123");
        mockExecute(signInRequestDto, 404, "$.message", "Entity not found exception");

        // negative #4
        // проверяем на невалидный email
        signInRequestDto = new SignInRequestDto("user1_test#gmail.com", "Qwerty123");
        mockExecute(signInRequestDto, 400, "$.fields[0].message", "must be a well-formed email address");

        // negative #5
        // проверяем на несуществующего юзера (EntityNotFoundException)
        signInRequestDto = new SignInRequestDto(user999, "123456789");
        getMockMvc().perform(
                post(SIGN_IN)
                        .content(TestUtils.objectToJsonString(signInRequestDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().is(404))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof EntityNotFoundException));
    }

    @Test
    public void signUpTest() throws Exception {

        SignUpRequestDto signUpRequestDto;
        PasswordRequestDto passwordRequestDto;

        // positive #1
        // проверяем успешную регистрацию (+ сравниваем ушедший email с пришедшим)
        signUpRequestDto = TestUtils.getSignUpRequestDto("user111");
        mockExecute(signUpRequestDto, 200, "$.data.accountResponseDto.email", signUpRequestDto.getEmail());

        // negative #1
        // проверяем на пустой/null email
        signUpRequestDto = TestUtils.getSignUpRequestDto("user222");
        signUpRequestDto.setEmail(null);
        mockExecute(signUpRequestDto, 400, "$.fields[0].message", "must not be blank");

        // negative #2
        // проверяем на невалидный email
        signUpRequestDto = TestUtils.getSignUpRequestDto("user333");
        signUpRequestDto.setEmail("user333_test#gmail.com");
        mockExecute(signUpRequestDto, 400, "$.fields[0].message", "must be a well-formed email address");

        // negative #3
        // проверяем короткий пароль
        signUpRequestDto = TestUtils.getSignUpRequestDto("user444");
        passwordRequestDto = signUpRequestDto.getPasswords();
        passwordRequestDto.setPassword("1234");
        passwordRequestDto.setPasswordConfirm("1234");
        mockExecute(signUpRequestDto, 400, "$.fields[*].message", "The 'password' must be greater than or equal to 8");

        // negative #4
        // проверяем несовпадающие пароли
        signUpRequestDto = TestUtils.getSignUpRequestDto("user444");
        passwordRequestDto = signUpRequestDto.getPasswords();
        passwordRequestDto.setPassword("Qwerty123");
        passwordRequestDto.setPasswordConfirm("qwerty123");
        mockExecute(signUpRequestDto, 400, "$.fields[0].message", "'Password' and 'PasswordConfirm' must be identical");

        // negative #5
        // проверяем - User с таким email уже существует EntityExistException
        signUpRequestDto = TestUtils.getSignUpRequestDto("user1");
        mockExecute(signUpRequestDto, 400, "$.fields[0].message", "Such user already exists");
    }

    private void mockExecute(SignInRequestDto signInRequestDto, int status, String field, String message) throws Exception {
        getMockMvc().perform(
                post(SIGN_IN)
                        .content(TestUtils.objectToJsonString(signInRequestDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().is(status))
                .andExpect(jsonPath(field).value(message));
    }

    private void mockExecute(SignUpRequestDto signUpRequestDto, int status, String field, String message) throws Exception {
        getMockMvc().perform(
                post(SIGN_UP)
                        .content(TestUtils.objectToJsonString(signUpRequestDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().is(status))
                .andExpect(jsonPath(field).value(message));
    }
}
