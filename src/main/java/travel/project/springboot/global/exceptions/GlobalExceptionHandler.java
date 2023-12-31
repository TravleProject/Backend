package travel.project.springboot.global.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import travel.project.springboot.global.response.MakeResponse;
import travel.project.springboot.global.response.ResponseMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<ResponseMessage<Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
        return MakeResponse.getResponseMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    public ResponseEntity<ResponseMessage<Object>> handleGeneralException(Exception ex) {
        return MakeResponse.getResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

}

