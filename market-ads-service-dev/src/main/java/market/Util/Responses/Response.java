package market.Util.Responses;


public abstract class Response<T> {

    public static Response.ErrorBuilderImpl error() {
        return new ErrorBuilderImpl();
    }


    public static Response.Builder ok() {
        return new SuccessBuilderImpl();
    }

    public static <T> SuccessResponse<T> ok(T data) {
        return new SuccessResponse<>(data);
    }


    interface Builder {
        public Response build();
    }

    static record SuccessBuilderImpl() implements Builder {

        @Override
        public SuccessResponse<String> build() {
            return new SuccessResponse<>("");
        }
    }

    static class ErrorBuilderImpl implements Builder {
        final Error error;

        public ErrorBuilderImpl() {
            error = new Error();
        }


        @Override
        public ErrorResponse build() {
            return new ErrorResponse(error);
        }

        public Builder code(Integer code) {
            error.setCode(code);
            return this;
        }


        public Builder text(String message) {
            error.setText(message);
            return this;
        }

    }

}
