package com.java.identity_service.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Represents a generic API response structure.
 *
 * @param <T> the type of the result object
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    public int code = 200;
    public String message;
    public T result;

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
