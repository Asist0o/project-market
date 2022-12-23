package market.Util.Responses;

import org.apache.http.HttpStatus;

public class ErrorResponse extends Response {
    private final Error error;

    public ErrorResponse(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
