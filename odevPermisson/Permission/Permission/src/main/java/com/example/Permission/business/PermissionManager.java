package com.example.Permission.business;

import com.example.Permission.business.abstracts.PermissionService;
import com.example.Permission.business.concretes.requests.CreatePermissionRequest;
import com.example.Permission.business.concretes.requests.UpdatePermissionRequest;
import com.example.Permission.business.concretes.responses.PermissionResponses;
import com.example.Permission.dataAccess.abstracts.PermissionRepository;
import com.example.Permission.mapper.abstracts.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.Permission.entities.concretes.PermissonEntity;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PermissionManager implements PermissionService {
    private final PermissionRepository permissionRepository;
    private final ModelMapperService modelMapperService;

    public PermissionManager(PermissionRepository permissionRepository, ModelMapperService modelMapperService) {
        this.permissionRepository = permissionRepository;
        this.modelMapperService = modelMapperService;
    }
    @Override
    public void addPermission(CreatePermissionRequest createPermissionRequest) {
        PermissonEntity permission = this.modelMapperService.forRequest()
                .map(createPermissionRequest, PermissonEntity.class);
        this.permissionRepository.save(permission);
    }

    @Override
    public void deletePermission(int id) {
        this.permissionRepository.deleteById(id);
    }

    @Override
    public void updatePermission(UpdatePermissionRequest updatePermissionRequest) {
        PermissonEntity permission = this.modelMapperService.forRequest()
                .map(updatePermissionRequest, PermissonEntity.class);
        this.permissionRepository.save(permission);
    }

    @Override
    public List<PermissionResponses> getAllPermission() {
        List<PermissonEntity> permissions = this.permissionRepository.findAll();
        if (permissions.isEmpty()) {
            throw new RuntimeException("Permission not found");
        }
        List<PermissionResponses> responses = permissions.stream()
                .map(permission -> this.modelMapperService.forResponses().map(permission, PermissionResponses.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public PermissionResponses getPermissionById(int id) {
        PermissonEntity permission = this.permissionRepository.findById(id).orElse(null);
        if (permission == null) {
            throw new RuntimeException("Permission not found");
        }
        PermissionResponses permissionResponses = this.modelMapperService
                .forResponses()
                .map(permission, PermissionResponses.class);
        return permissionResponses;
    }
}
