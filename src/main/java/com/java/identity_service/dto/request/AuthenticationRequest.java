package com.java.identity_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
// Set two constructors: no-args and all-args
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationRequest {
    String username;
    String password;
}
