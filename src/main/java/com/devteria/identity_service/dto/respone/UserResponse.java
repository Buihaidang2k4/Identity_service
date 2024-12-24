package com.devteria.identity_service.dto.respone;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String username;
   // String password;
    String firstname;
    String lastname;
    LocalDate dob;
    Set<String> roles;
}
