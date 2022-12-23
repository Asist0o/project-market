package market.response;


public abstract class Response<T> {

    public static ErrorBuilder error() {
        return new ErrorBuilder();
    }

    public static SuccessBuilder success() {
        return new SuccessBuilder();
    }

    public static <T> SuccessResponse<T> success(T data) {
        return new SuccessResponse<>(data);
    }
}
