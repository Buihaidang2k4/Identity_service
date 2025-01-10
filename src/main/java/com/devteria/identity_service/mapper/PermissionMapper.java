package com.devteria.identity_service.mapper;

import com.devteria.identity_service.dto.request.PermissionRequest;
import com.devteria.identity_service.dto.request.UserCreationRequest;
import com.devteria.identity_service.dto.request.UserUpdateRequest;
import com.devteria.identity_service.dto.respone.PermissionRespone;
import com.devteria.identity_service.dto.respone.UserResponse;
import com.devteria.identity_service.entity.Permission;
import com.devteria.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);// dung de khoi tao user

    PermissionRespone toPermissionResponse(Permission  permission);

}
