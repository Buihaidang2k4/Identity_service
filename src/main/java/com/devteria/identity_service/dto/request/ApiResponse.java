package com.devteria.identity_service.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL) // anotasion nay cho biet cai nao null not show
// Api  nay khoi tao chuan hoa cho response khi tra ve ket qua
public class ApiResponse<T> {
    int code = 1000; //   RESULT SUCCESS
    String message;
    T result;
}
