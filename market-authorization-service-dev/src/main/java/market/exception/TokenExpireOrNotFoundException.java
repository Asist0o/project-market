package market.exception;

public class TokenExpireOrNotFoundException extends RuntimeException {
    public TokenExpireOrNotFoundException(String message) {
        super(message);
    }
}
