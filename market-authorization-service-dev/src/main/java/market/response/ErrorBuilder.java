package market.response;

public class ErrorBuilder<T> implements Builder<T> {

    private final Error error;

    public ErrorBuilder() {
        error = new Error();
    }

    @Override
    public Response<T> build() {
        return new ErrorResponse<>(error);
    }

    public ErrorBuilder<T> code(Integer code) {
        error.setCode(code);
        return this;
    }


    public ErrorBuilder<T> message(String message) {
        error.setMessage(message);
        return this;
    }
}