package market.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
class ApiError {

    private Integer status;
    private HttpStatus error;
    private String message;
    //    private String debugMessage;
    private List<ErrorField> fields;

    private ApiError() {
    }

    ApiError(HttpStatus httpStatus) {
        this();
        this.status = httpStatus.value();
        this.error = httpStatus;
    }

//    ApiError(HttpStatus httpStatus, Throwable throwable) {
//        this();
//        this.status = httpStatus.value();
//        this.error = httpStatus;
//        this.message = "Unexpected error";
//        //this.debugMessage = throwable.getMessage();
//    }

    ApiError(HttpStatus httpStatus, String message, Throwable throwable) {
        this();
        this.status = httpStatus.value();
        this.error = httpStatus;
        this.message = message;
//        this.debugMessage = throwable.getMessage();
    }

    void addValidationFieldError(List<FieldError> errorFieldList) {
        errorFieldList.forEach(error -> {
            ErrorField errorField = new ErrorField();
            errorField.setObject(error.getObjectName());
            errorField.setField(error.getField());
            errorField.setValue(error.getRejectedValue());
            errorField.setMessage(error.getDefaultMessage());
            addErrorField(errorField);
        });
    }

    void addValidationObjectError(List<ObjectError> objectErrorList) {
        objectErrorList.forEach(error -> {
            ErrorField errorField = new ErrorField();
            errorField.setObject(error.getObjectName());
            errorField.setField("");
            errorField.setValue("");
            errorField.setMessage(error.getDefaultMessage());
            addErrorField(errorField);
        });
    }

    private void addErrorField(ErrorField errorField) {
        if (fields == null) {
            fields = new ArrayList<>();
        }
        if (fields.stream().noneMatch(item -> item.getObject().equals(errorField.getObject()) && item.getMessage().equals(errorField.getMessage()))) {
            fields.add(errorField);
        }
    }
}