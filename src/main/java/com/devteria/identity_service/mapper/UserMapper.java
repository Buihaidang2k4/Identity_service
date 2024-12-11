package com.devteria.identity_service.mapper;

import com.devteria.identity_service.dto.request.UserCreationRequest;
import com.devteria.identity_service.dto.request.UserUpdateRequest;
import com.devteria.identity_service.dto.respone.UserResponse;
import com.devteria.identity_service.dto.respone.UserResponse;
import com.devteria.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreationRequest request);// dung de khoi tao user
//    @Mapping(source ="firstname",target = "lastname")
//    @Mapping(target ="firstname",ignore = true)
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
