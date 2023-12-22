package travel.project.springboot.global.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseMessage<T> {
    private int status; // HTTP 상태 코드 HttpStatus 대신 정수 사용 -> DTO의 역할에 집중
    private String message;
    private T data; // 제네릭 타입 사용

    public ResponseMessage(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }
}
