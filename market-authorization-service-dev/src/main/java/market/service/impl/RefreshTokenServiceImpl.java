package market.service.impl;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import market.dto.AccessPairDto;
import market.dto.SignInJwtDto;
import market.dto.converter.impl.AccountConverter;
import market.entity.RefreshToken;
import market.repository.RefreshTokenRepository;
import market.service.AccountService;
import market.service.JwtService;
import market.service.RefreshTokenService;
import org.springframework.stereotype.Component;


import java.util.Optional;
@Component
@AllArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {
    private final AccountService accountService;
    private final AccountConverter accountConverter;
    private final JwtService jwtService;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public Optional<?> findRefreshTokenByIdAndToken(Long id, RefreshToken token){
        return refreshTokenRepository.findRefreshTokenByIdAndToken(id, token);
    }

    public AccessPairDto getRefreshTokenResponseDto (Long userId, RefreshToken token) throws NotFoundException {
        String accessToken;
        String refreshToken;

        if (findRefreshTokenByIdAndToken(userId, token).isPresent()) {
            SignInJwtDto sign = accountConverter.convertToSignInJwtDto(accountService.findAccountById(userId));
            accessToken = jwtService.getAccessDto(sign).accessToken();
            refreshToken = jwtService.getAccessDto(sign).refreshToken();
        }
        else {
            throw new NotFoundException("Not valid refresh token");
        }

        return new AccessPairDto (accessToken, refreshToken);
    }

}
