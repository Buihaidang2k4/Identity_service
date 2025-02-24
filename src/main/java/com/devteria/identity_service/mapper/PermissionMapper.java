package com.devteria.identity_service.mapper;

import org.mapstruct.Mapper;

import com.devteria.identity_service.dto.request.PermissionRequest;
import com.devteria.identity_service.dto.respone.PermissionRespone;
import com.devteria.identity_service.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request); // dung de khoi tao user

    PermissionRespone toPermissionResponse(Permission permission);
}
