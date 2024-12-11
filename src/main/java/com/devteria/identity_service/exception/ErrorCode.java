package com.devteria.identity_service.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "UNCATEGORIZED ERROR"),
    INVALID_KEY(1001,"INVALID MESSAGE KEY"),
    USER_EXISTED(1002,"User existed"),
    USERNAME_INVALID(1003,"Username must be at least 4 characters"),
    INVALID_PASSWORD(1004,"PASSWORD must be at least 8 characters"),
    USER_NOT_EXISTED(1005,"User not existed"),
    UNAUTHENTICATED(1006,"UNAUTHENTICATED")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    int code;
    String message;

}
