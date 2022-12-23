package market.Util.Responses;


public class SuccessResponse<T> extends Response {
    private final T data;

    public SuccessResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
