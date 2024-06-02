package poison.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "회원 정보가 없습니다."),
    USER_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "인증이 필요합니다."),
    USER_FORBIDDEN(HttpStatus.FORBIDDEN, "접근 권한이 없습니다.");


    private final HttpStatus status;
    private final String errorMessage;
}
