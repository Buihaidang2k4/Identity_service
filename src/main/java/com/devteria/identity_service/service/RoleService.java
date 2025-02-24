package com.devteria.identity_service.service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devteria.identity_service.dto.request.RoleRequest;
import com.devteria.identity_service.dto.respone.RoleRespone;
import com.devteria.identity_service.mapper.RoleMapper;
import com.devteria.identity_service.repository.PermissionRepository;
import com.devteria.identity_service.repository.RoleRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor // final, Autowired
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    public RoleRespone create(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permision = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permision));

        roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleRespone> getALL() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).collect(Collectors.toList());
    }

    public void delete(String role) {
        roleRepository.deleteById(role);
    }
}
