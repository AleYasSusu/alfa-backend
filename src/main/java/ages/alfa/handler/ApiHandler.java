package ages.alfa.handler;

import ages.alfa.dto.ErrorResponse;
import ages.alfa.exception.ApiErrorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiHandler {

    @ExceptionHandler(ApiErrorException.class)
    public ResponseEntity<ErrorResponse<String>> handlerCursoException(ApiErrorException ex) {

        ErrorResponse<String> errorResponse = new ErrorResponse<>();
        errorResponse.setStatusCode(ex.getHttpStatus().value());
        errorResponse.setData(ex.getMessage());

        return ResponseEntity.status(ex.getHttpStatus()).body(errorResponse);
    }
}
