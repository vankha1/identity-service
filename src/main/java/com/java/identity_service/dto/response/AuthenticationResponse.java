package com.java.identity_service.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
// Set two constructors: no-args and all-args
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {
    boolean isAuthenticated;
}
