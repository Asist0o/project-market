package market.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.Objects;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * example:
     * <pre>
     * {
     *   "status": 400,
     *   "error": "NOT_FOUND",
     *   "message": "no handler found",
     *   "debugMessage": "No handler found for for GET /api/getSomethingById/123"
     * }
     * </pre>
     */
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException exception,
                                                                   HttpHeaders httpHeaders,
                                                                   HttpStatus httpStatus,
                                                                   WebRequest webRequest) {
        return new ResponseEntity<>(new ApiError(httpStatus, "No handler found", exception), HttpStatus.NOT_FOUND);
    }

    /**
     * example:
     * <pre>
     * {
     *   "status": 400,
     *   "error": "BAD_REQUEST",
     *   "message": "Validation exception",
     *   "errors": [
     *     {
     *       "object": "userRegistrationDto",
     *       "field": "userId",
     *       "value": null,
     *       "message": "User doesn't exist"
     *     },
     *     {
     *       "object": "userRegistrationDto",
     *       "field": "userId",
     *       "value": null,
     *       "message": "The field cannot be null"
     *     }
     *   ]
     * }
     * </pre>
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders httpHeaders,
                                                                  HttpStatus httpStatus,
                                                                  WebRequest webRequest) {
        ApiError apiError = new ApiError(httpStatus, "Validation exception", exception);
        apiError.addValidationFieldError(exception.getBindingResult().getFieldErrors());
        apiError.addValidationObjectError(exception.getBindingResult().getAllErrors());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    /**
     * example:
     * <pre>
     * {
     *   "status": 400,
     *   "error": "BAD_REQUEST",
     *   "message": "Malformed JSON request"
     * }
     * </pre>
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception,
                                                                  HttpHeaders httpHeaders,
                                                                  HttpStatus httpStatus,
                                                                  WebRequest webRequest) {
        ApiError apiError = new ApiError(httpStatus, "Malformed JSON request", exception);
        return new ResponseEntity<>(apiError, httpStatus);
    }

    /**
     * example
     * <pre>
     * {
     *   "status": 401,
     *   "error": "UNAUTHORIZED",
     *   "message": "Authentication exception"
     * }
     * </pre>
     */
    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    public ResponseEntity<ApiError> handle(AuthenticationCredentialsNotFoundException exception) {
        ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, "Authentication exception", exception);
        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
    }

    /**
     * example
     * <pre>
     * {
     *   "status": 401,
     *   "error": "UNAUTHORIZED",
     *   "message": "OAuth2 exception"
     * }
     * </pre>
     */
    @ExceptionHandler(OAuth2AuthenticationException.class)
    public ResponseEntity<ApiError> handle(OAuth2AuthenticationException exception) {
        ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, "OAuth2 exception", exception);
        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
    }

    /**
     * example:
     * <pre>
     * {
     *   "status": 400,
     *   "error": "BAD_REQUEST",
     *   "message": "The parameter 'field' of value 'xxx' could not be converted to type 'Integer'"
     * }
     * </pre>
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ApiError> handle(MethodArgumentTypeMismatchException exception,
                                              WebRequest webRequest) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(
                String.format("The parameter '%s' of value '%s' could not be converted to type '%s'",
                        exception.getName(),
                        exception.getValue(),
                        Objects.requireNonNull(exception.getRequiredType()).getSimpleName())
        );
        // apiError.setDebugMessage(methodArgumentTypeMismatchException.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    /**
     * example:
     * <pre>
     * {
     *   "status": 404,
     *   "error": "NOT_FOUND",
     *   "message": "Entity not found exception"
     * }
     * </pre>
     */
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<ApiError> handle(EntityNotFoundException exception,
                                              WebRequest webRequest) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "Entity not found exception", exception);
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    /**
     * example:
     * <pre>
     * {
     *   "status": 302,
     *   "error": "FOUND",
     *   "message": "Entity exists exception"
     * }
     * </pre>
     */
    @ExceptionHandler(EntityExistsException.class)
    protected ResponseEntity<ApiError> handle(EntityExistsException exception,
                                              WebRequest webRequest) {
        ApiError apiError = new ApiError(HttpStatus.FOUND, "Entity exists exception", exception);
        return new ResponseEntity<>(apiError, HttpStatus.FOUND);
    }

    /**
     * example:
     * <pre>
     * {
     *   "status": 400,
     *   "error": "BAD_REQUEST",
     *   "message": "Validation exception"
     * }
     * </pre>
     */
    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<ApiError> handle(ValidationException exception,
                                              WebRequest webRequest) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Validation exception", exception);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    /**
     * example:
     * <pre>
     * {
     *   "status": 404,
     *   "error": "NOT_FOUND",
     *   "message": "Empty result (from database)"
     * }
     * </pre>
     */
    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<ApiError> handle(EmptyResultDataAccessException exception,
                                              WebRequest webRequest) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "Empty result (from database)", exception);
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(Exception.class)
//    protected ResponseEntity<Object> handle(Exception exception,
//                                            WebRequest request) {
//        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", exception);
//        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}