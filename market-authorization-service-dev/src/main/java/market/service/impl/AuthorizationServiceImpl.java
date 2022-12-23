package market.service.impl;

import market.dto.*;
import market.dto.converter.Converter;
import market.entity.Account;
import market.service.AccountService;
import market.service.AuthorizationService;
import market.service.JwtService;
import market.service.ProducerKafkaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {

    private final AccountService accountService;
    private final ProducerKafkaService producerKafkaService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final Converter<Account, AccountResponseDto> converter;

    public AuthorizationServiceImpl(AccountService accountService,
                                    ProducerKafkaService producerKafkaService,
                                    JwtService jwtService,
                                    PasswordEncoder passwordEncoder,
                                    Converter<Account, AccountResponseDto> converter) {
        this.accountService = accountService;
        this.producerKafkaService = producerKafkaService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.converter = converter;
    }

    @Value("${jwt.token.expiration}")
    private Long jwtExpiration;

    @Override
    public AuthResponseDto signIn(SignInRequestDto signInRequestDto) {
        Account account = accountService.findAccountByEmail(signInRequestDto.email());
        if (passwordEncoder.matches(signInRequestDto.password(), account.getPassword())) {
            return createAuthResponse(converter.convertToDto(account));
        }
        throw new AuthenticationCredentialsNotFoundException("Invalid password");
    }

    @Override
    public AuthResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        AccountResponseDto accountResponseDto = accountService.saveAccount(signUpRequestDto);
//        producerKafkaService.send(new ProfileDto(
//                accountResponseDto.getId(), accountResponseDto.getEmail(), accountResponseDto.getFirstName(), accountResponseDto.getLastName())
//        );
        return createAuthResponse(accountResponseDto);
    }

    private AuthResponseDto createAuthResponse(AccountResponseDto accountResponseDto) {
        return new AuthResponseDto(
                accountResponseDto, new AuthTokenDto(jwtService.createToken(accountResponseDto), jwtExpiration)
        );
    }
}
