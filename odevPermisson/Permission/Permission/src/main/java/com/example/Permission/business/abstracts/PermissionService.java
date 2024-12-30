package com.example.Permission.business.abstracts;

import com.example.Permission.business.concretes.requests.CreatePermissionRequest;
import com.example.Permission.business.concretes.requests.UpdatePermissionRequest;
import com.example.Permission.business.concretes.responses.PermissionResponses;

import java.util.List;

public interface PermissionService {
    void addPermission(CreatePermissionRequest createPermissionRequest);
    void deletePermission(int id);
    void updatePermission(UpdatePermissionRequest updatePermissionRequest);
    List<PermissionResponses> getAllPermission();
    PermissionResponses getPermissionById(int id);
}
