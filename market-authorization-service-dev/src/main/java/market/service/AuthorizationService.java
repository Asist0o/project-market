package market.service;

import market.dto.AuthResponseDto;
import market.dto.SignInRequestDto;
import market.dto.SignUpRequestDto;

public interface AuthorizationService {

    AuthResponseDto signIn(SignInRequestDto userAuthorizationDto);

    AuthResponseDto signUp(SignUpRequestDto request);
}
