package com.devteria.identity_service.mapper;

import com.devteria.identity_service.dto.request.PermissionRequest;
import com.devteria.identity_service.dto.request.RoleRequest;
import com.devteria.identity_service.dto.respone.PermissionRespone;
import com.devteria.identity_service.dto.respone.RoleRespone;
import com.devteria.identity_service.entity.Permission;
import com.devteria.identity_service.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions",ignore = true) // Vi enity tra ve mot set ma request tra ve string len se loi phai ignore
    Role toRole(RoleRequest request);// dung de khoi tao user

    RoleRespone toRoleResponse(Role  role);

}
