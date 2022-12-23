package market.service;

import market.dto.AccessPairDto;
import market.dto.AccountResponseDto;
import market.dto.SignInJwtDto;

public interface JwtService {

    String createToken(AccountResponseDto accountResponseDto);

    AccessPairDto getAccessDto(SignInJwtDto sign);
}

