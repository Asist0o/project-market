package market.service;

public interface PasswordResetTokenService {

    void resetPassword(String email);

    void verifyToken(String uniqueKeyForReset);
}
