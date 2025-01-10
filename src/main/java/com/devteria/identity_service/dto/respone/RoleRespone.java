package com.devteria.identity_service.dto.respone;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.security.Permission;
import java.util.Set;

// Cung cap thong tin dang nhap
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL) // anotasion nay cho biet cai nao null not show
public class RoleRespone {
    String name;
    String description;
    Set<PermissionRespone> permissions;
}
