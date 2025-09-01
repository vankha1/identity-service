package com.java.identity_service.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Represents a generic API response structure.
 *
 * @param <T> the type of the result object
 */
@Data
// Set two constructors: no-args and all-args
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    int code = 200;
    String message;
    T result;
}
