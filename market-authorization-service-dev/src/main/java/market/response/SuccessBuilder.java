package market.response;

import org.springframework.http.HttpStatus;

public class SuccessBuilder<T> implements Builder<T> {

    private SuccessResponse<T> successResponse;

    @Override
    public SuccessResponse<T> build() {
        return successResponse;
    }

    public SuccessBuilder<T> data(T data) {
        successResponse.setData(data);
        return this;
    }

    public SuccessBuilder<T> status(HttpStatus status) {
        successResponse.setStatus(status);
        return this;
    }

}