package market.controller.inner;

import javassist.NotFoundException;
import market.dto.AccessPairDto;
import market.entity.RefreshToken;
import market.service.RefreshTokenService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefreshTokenRestController {
    private final RefreshTokenService refreshTokenService;

    public RefreshTokenRestController(RefreshTokenService refreshTokenService) {
        this.refreshTokenService = refreshTokenService;
    }

    @PutMapping("/refresh_tokens")
    public AccessPairDto getRefreshTokens(@RequestParam Long userId, @RequestParam RefreshToken token) throws NotFoundException {
        return refreshTokenService.getRefreshTokenResponseDto(userId, token);
    }
}
