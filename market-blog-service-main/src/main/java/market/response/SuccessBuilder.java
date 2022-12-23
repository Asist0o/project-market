package market.response;

public class SuccessBuilder<T> implements Builder {

    private SuccessResponse<T> successResponse;

    @Override
    public SuccessResponse<T> build() {
        return successResponse;
    }

    public SuccessBuilder data(T data) {
        successResponse.setData(data);
        return this;
    }

    public SuccessBuilder status(Integer status) {
        successResponse.setStatus(status);
        return this;
    }

}