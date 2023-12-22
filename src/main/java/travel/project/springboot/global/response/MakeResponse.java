package travel.project.springboot.global.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.nio.charset.StandardCharsets;

public class MakeResponse {

    public static <T> ResponseEntity<ResponseMessage<T>> getResponseMessage(HttpStatus status, String message, T data) {
        ResponseMessage<T> responseMessage = new ResponseMessage<>(status.value(), message, data);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        return new ResponseEntity<>(responseMessage, headers, status);
    }

    public static ResponseEntity<ResponseMessage<Object>> getResponseMessage(HttpStatus status, String message) {
        ResponseMessage<Object> responseMessage = new ResponseMessage<>(status.value(), message, null);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        return new ResponseEntity<>(responseMessage, headers, status);
    }
}
