package market.controller;

import market.entity.PasswordResetToken;
import market.response.Response;
import market.service.PasswordResetTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//todo: nik: уточнить корневой эндпоинт
@RequestMapping("/api/resetPassword")
public class PasswordResetTokenController {

    private final PasswordResetTokenService passwordResetTokenService;

    public PasswordResetTokenController(PasswordResetTokenService passwordResetTokenService) {
        this.passwordResetTokenService = passwordResetTokenService;
    }

    @PostMapping("/reset")
    public Response<PasswordResetToken> resetPassword(@RequestParam("email") String email) {
        passwordResetTokenService.resetPassword(email);
        return Response.success(HttpStatus.OK);
    }

    @PostMapping("/verify")
    public Response<PasswordResetToken> verifyToken(@RequestParam("token") String token) {
        passwordResetTokenService.verifyToken(token);
        return Response.success(HttpStatus.OK);
    }
}
