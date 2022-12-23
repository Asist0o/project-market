package market.response;

public class ErrorResponse<T> extends Response<T> {

    private final Error error;

    public ErrorResponse(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
