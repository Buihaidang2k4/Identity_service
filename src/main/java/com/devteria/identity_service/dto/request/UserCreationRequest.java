package com.devteria.identity_service.dto.request;

import com.devteria.identity_service.exception.ErrorCode;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
//@Getter // Auto generate getter (Lombok)
//@Setter

@Data // Auto create getter setter constructor toString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) // Nếu trong class không định nghĩa thì nó sẽ là private
public class UserCreationRequest {

    @Size(min = 4, message = "USERNAME_INVALID") // Truyen theo key cua ErrorCode // dam bao ten co do dai = 4 toi thieu
    String username;
    // Khai bao validation cho password
    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;
    String firstname;
    String lastname;
    LocalDate dob;
}
