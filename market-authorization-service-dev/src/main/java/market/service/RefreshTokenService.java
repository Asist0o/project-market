package market.service;

import javassist.NotFoundException;
import market.dto.AccessPairDto;
import market.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {

    Optional<?> findRefreshTokenByIdAndToken(Long userId, RefreshToken token) throws NotFoundException;
    AccessPairDto getRefreshTokenResponseDto (Long userId, RefreshToken token) throws NotFoundException;


}