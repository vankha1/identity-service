package com.java.identity_service.exception;

public enum ErrorCode {
    UNCATEGORIZED_ERROR(0, "Uncategorized error"),
    INVALID_KEY(1, "Invalid key"), // Used for invalid wrong keys of ErrorCode
    USER_EXISTED(1001, "User exists with this username"),
    USERNAME_INVALID(1002, "Username must be between 3 and 20 characters long"),
    PASSWORD_INVALID(1003, "Password must be at least 8 characters long"),
    ;
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
