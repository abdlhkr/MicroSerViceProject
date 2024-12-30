package com.example.Roles.business.abstracts;

import com.example.Roles.business.concretes.requests.CreateRoleRequest;
import com.example.Roles.business.concretes.requests.UpdateRoleRequest;
import com.example.Roles.business.concretes.responses.RoleResponse;
import com.example.Roles.entities.Roles;

import java.util.List;

public interface RoleService {
    List<RoleResponse> getAll();
    RoleResponse add(CreateRoleRequest createRoleRequest);
    RoleResponse getByID(int id);
    RoleResponse update(UpdateRoleRequest updateRoleRequest);
    RoleResponse delete(int id);
}
