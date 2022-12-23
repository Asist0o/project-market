package market.controller.out;

import lombok.AllArgsConstructor;
import market.dto.*;
import market.response.Response;
import market.service.AuthorizationService;
import market.service.JwtService;
import market.util.CookieUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthorizationController {
    private final AuthorizationService authorizationService;
    private final JwtService jwtService;
    private final CookieUtil cookieUtil;

    @PostMapping("/signIn")
    public Response<AuthResponseDto> signIn(@Valid @RequestBody SignInRequestDto signInRequestDto) {
        return Response.success(authorizationService.signIn(signInRequestDto), HttpStatus.OK);
    }

    @PostMapping("/signUp")
    public void signUp(@Valid @RequestBody SignInJwtDto sign, HttpServletResponse httpServletResponse) {
        cookieUtil.setCookieInResponse(httpServletResponse, jwtService.getAccessDto(sign));
    }

}

