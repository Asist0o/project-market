package market.response;


import org.springframework.http.HttpStatus;

public abstract class Response<T> {

    public static <T> ErrorBuilder<T> error() {
        return new ErrorBuilder<>();
    }

    public static <T> SuccessBuilder<T> success() {
        return new SuccessBuilder<>();
    }

    public static <T> SuccessResponse<T> success(T data, HttpStatus status) {
        return new SuccessResponse<>(data, status);
    }

    public static <T> SuccessResponse<T> success(HttpStatus status) {
        return new SuccessResponse<>(status);
    }
}