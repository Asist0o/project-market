package market.service.impl;

import lombok.AllArgsConstructor;
import market.entity.Account;
import market.entity.PasswordResetToken;
import market.exception.AccountNotExistException;
import market.exception.TokenExpireOrNotFoundException;
import market.repository.PasswordResetTokenRepository;
import market.service.AccountService;
import market.service.PasswordResetTokenService;
import market.service.ProducerKafkaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.UUID;

@AllArgsConstructor
@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final AccountService accountService;
    private final ProducerKafkaService kafkaService;

    @Transactional
    @Override
    public void resetPassword(String email) {
        Account account = accountService.findAccountByEmail(email);
        if (account == null) {
            throw new AccountNotExistException("Account with email: " + email + " not found");
        }
        passwordResetTokenRepository.deleteAllByAccountId(account.getId());
        String uniqueKeyForReset = UUID.randomUUID().toString();
        //todo: nik: что нужно отправялть на почту
        kafkaService.sendTokenEmail(createPasswordResetTokenForAccount(account, uniqueKeyForReset));
    }

    @Override
    public void verifyToken(String uniqueKeyForReset) {
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(uniqueKeyForReset).orElseThrow(
                () -> new TokenExpireOrNotFoundException(String.format("Token: %s expire or not found", uniqueKeyForReset))
        );
        if (isTokenExpired(passwordResetToken)) {
            throw new TokenExpireOrNotFoundException(String.format("Token: %s expire or not found", uniqueKeyForReset));
        }
    }

    private PasswordResetToken createPasswordResetTokenForAccount(Account account, String token) {
        return passwordResetTokenRepository.save(new PasswordResetToken(account, token));
    }

    private boolean isTokenExpired(PasswordResetToken passToken) {
        return passToken.getExpiryDate().before(Calendar.getInstance().getTime());
    }
}
