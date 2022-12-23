package market.response;


import org.springframework.http.HttpStatus;

public class SuccessResponse<T> extends Response<T> {

    private T data;
    private HttpStatus status;


    public SuccessResponse(T data, HttpStatus status) {
        this.data = data;
        this.status = status;
    }

    public SuccessResponse(HttpStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
