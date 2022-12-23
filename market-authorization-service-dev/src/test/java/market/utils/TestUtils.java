package market.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import market.dto.AccountResponseDto;
import market.dto.PasswordRequestDto;
import market.dto.ProfileDto;
import market.dto.SignUpRequestDto;
import market.entity.Account;
import market.entity.Role;

public class TestUtils {

    public static Role getRole() {
        return getRole("ROLE_USER");
    }

    public static Role getRole(String name) {
        Role role = new Role();
        role.setAuthority(name);
        return role;
    }

    public static Account getAccount() {
        return getAccount("user");
    }

    public static Account getAccount(String name) {
        Account account = new Account();
        account.setEmail(name + "@gmail.com");
        account.setRole(getRole("ROLE_" + name.toUpperCase()));
        account.setPassword("Qwerty123");
        return account;
    }

    public static ProfileDto getProfileDto(AccountResponseDto accountResponseDto) {
        return new ProfileDto(
                accountResponseDto.getId(),
                accountResponseDto.getEmail(),
                accountResponseDto.getFirstName(),
                accountResponseDto.getLastName()
        );
    }

    public static SignUpRequestDto getSignUpRequestDto(String name) {
        PasswordRequestDto passwordRequestDto = new PasswordRequestDto();
        passwordRequestDto.setPassword("Qwerty123");
        passwordRequestDto.setPasswordConfirm("Qwerty123");
        SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
        signUpRequestDto.setFirstName(name + "_name_test");
        signUpRequestDto.setLastName(name + "last_name_test");
        signUpRequestDto.setEmail(name + "_test@gmail.com");
        signUpRequestDto.setPasswords(passwordRequestDto);
        return signUpRequestDto;
    }

    public static String objectToJsonString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
