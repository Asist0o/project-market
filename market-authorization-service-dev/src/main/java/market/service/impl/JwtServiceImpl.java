package market.service.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import market.dto.AccessPairDto;
import market.dto.AccountResponseDto;
import market.dto.SignInJwtDto;
import market.repository.RefreshTokenRepository;
import market.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Service
@PropertySource("classpath:jwt.properties")
public class JwtServiceImpl implements JwtService {
    @Autowired
    private RefreshTokenRepository refreshTokenService;

    @Value("${jwt.token.expiration.access}")
    private Long jwtExpirationByAccess;
    @Value("${jwt.token.expiration.refresh}")
    private Long jwtExpirationByRefresh;

    @Value("${jwt.token.secret.access}")
    private String secretByAccess;
    @Value("${jwt.token.secret.refresh}")
    private String secretByRefresh;

    public AccessPairDto getAccessDto(SignInJwtDto sign){
        final LocalDateTime baseDate = LocalDateTime.now();
        LocalDateTime forAccessToken = baseDate.plusMinutes(jwtExpirationByAccess);
        LocalDateTime forRefreshToken = baseDate.plusDays(jwtExpirationByRefresh);

        return new AccessPairDto(createAccessToken(sign, forAccessToken),
                createRefreshToken(sign, forRefreshToken));
    }

    private String createAccessToken(SignInJwtDto sign, LocalDateTime localDateTime) {
        return  Jwts.builder()
                .setExpiration(Date.from(Instant.from(localDateTime)))
                .claim("role", sign.getRole())
                .claim("account_id", sign.getId())
                .signWith(SignatureAlgorithm.HS256, secretByAccess)
                .compact();
    }

    private String createRefreshToken(SignInJwtDto sign, LocalDateTime localDateTime) {
        final String refreshToken = Jwts.builder()
                .setExpiration(Date.from(Instant.from(localDateTime)))
                .claim("account_id", sign.getId())
                .signWith(SignatureAlgorithm.HS256, secretByRefresh)
                .compact();
        refreshTokenService.save(refreshToken);
        return refreshToken;
    }


    public String createToken(AccountResponseDto accountResponseDto) {
        Date now = new Date();
        return Jwts.builder()
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 180000))
                .setSubject(accountResponseDto.getEmail())
                .claim("role", accountResponseDto.getRole())
                .claim("account_id", accountResponseDto.getId())
                .signWith(SignatureAlgorithm.HS256, "secret")
                .compact();
    }
}
