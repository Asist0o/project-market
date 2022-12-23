package market.rest.advice;

import market.anotation.ResponseExceptionHandler;
import market.exception.ResponseException;
import market.dto.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;

@RestControllerAdvice(annotations = ResponseExceptionHandler.class)
public class ResponseAdvice {

    @ExceptionHandler(value = {FileNotFoundException.class, NullPointerException.class, ResponseException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleException(Exception e) {
        return Response.error().code(500).message(e.getMessage()).build();
    }
}
