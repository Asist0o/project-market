package market.dto.response;

public class ErrorBuilder implements Builder {
    private Error error;

    public ErrorBuilder() {
        error = new Error();
    }


    @Override
    public Response build() {
        return new ErrorResponse(error);
    }

    public ErrorBuilder code(Integer code) {
        error.setCode(code);
        return this;
    }


    public ErrorBuilder message(String message) {
        error.setMessage(message);
        return this;
    }
}