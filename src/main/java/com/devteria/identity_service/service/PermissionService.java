package com.devteria.identity_service.service;

import com.devteria.identity_service.dto.request.PermissionRequest;
import com.devteria.identity_service.dto.respone.PermissionRespone;
import com.devteria.identity_service.entity.Permission;
import com.devteria.identity_service.mapper.PermissionMapper;
import com.devteria.identity_service.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor // final, Autowired
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;


   public PermissionRespone create(PermissionRequest request){
        Permission permission = permissionMapper.toPermission(request);

        // save database
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

   public List<PermissionRespone> getAll(){
        var permission =  permissionRepository.findAll();
        return permission.stream().map(permissionMapper::toPermissionResponse).toList();
    }

   public void delete(String permission){
        permissionRepository.deleteById(permission);
    }

}
