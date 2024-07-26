package com.supportkim.kimchimall.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    SUCCESS(HttpStatus.OK , "success" , "요청에 성공했습니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND , "not found" , "요청한 ID 에 해당하는 회원이 존재하지 않습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    public static ErrorCode findByMessage(String message) {
        for (ErrorCode response : ErrorCode.values()) {
            if (message.equals(response.message)) {
                return response;
            }
        }
        return null;
    }
}
