package com.devteria.identity_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.devteria.identity_service.dto.request.ApiResponse;
import com.devteria.identity_service.dto.request.RoleRequest;
import com.devteria.identity_service.dto.respone.RoleRespone;
import com.devteria.identity_service.service.RoleService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {
    RoleService roleService;

    @PostMapping
    ApiResponse<RoleRespone> createRole(@RequestBody RoleRequest request) {
        return ApiResponse.<RoleRespone>builder()
                .result(roleService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleRespone>> getRoles() {
        return ApiResponse.<List<RoleRespone>>builder()
                .result(roleService.getALL())
                .build();
    }

    @DeleteMapping("/{role}")
    ApiResponse<Void> deleteRole(@PathVariable String role) {
        roleService.delete(role);
        return ApiResponse.<Void>builder().build();
    }
}
