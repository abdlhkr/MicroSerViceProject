package com.example.Roles.business.concretes;

import com.example.Roles.business.abstracts.RoleService;
import com.example.Roles.business.concretes.requests.CreateRoleRequest;
import com.example.Roles.business.concretes.requests.UpdateRoleRequest;
import com.example.Roles.business.concretes.responses.RoleResponse;
import com.example.Roles.dataAccess.abstracts.RoleRepository;
import com.example.Roles.entities.Roles;
import com.example.Roles.mapper.concretes.ModelMapperManager;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
@Service
public class RoleManager implements RoleService {
    private RoleRepository roleRepository;
    private ModelMapperManager modelMapperManager;
    public RoleManager(RoleRepository roleRepository, ModelMapperManager modelMapperManager) {
        this.roleRepository = roleRepository;
        this.modelMapperManager = modelMapperManager;
    }

    @Override
    public List<RoleResponse> getAll() {
        List<Roles> roles = roleRepository.findAll();
        if (roles.isEmpty()) {
            throw new RuntimeException("Rol bulunamadı");
        }
        List<RoleResponse> responses = roles.stream()
                .map(role -> this.modelMapperManager.forResponses().map(role, RoleResponse.class))
                .collect(Collectors.toList());
        return responses;
    }


    @Override
    public RoleResponse add(CreateRoleRequest createRoleRequest) {
        Roles role = this.modelMapperManager.forRequest()
                .map(createRoleRequest, Roles.class);
        this.roleRepository.save(role);
        RoleResponse roleResponse = this.modelMapperManager
                .forResponses()
                .map(role, RoleResponse.class);
        return roleResponse;
    }

    @Override
    public RoleResponse getByID(int id) {
        Roles role = roleRepository.findById(id).orElse(null);
        if (role == null) {
            throw new RuntimeException("Rol bulunamadı");
        }
        RoleResponse roleResponse = this.modelMapperManager
                .forResponses()
                .map(role, RoleResponse.class);
        return roleResponse;
    }

    @Override
    public RoleResponse update(UpdateRoleRequest updateRoleRequest) {
        Roles role = this.modelMapperManager.forRequest()
                .map(updateRoleRequest, Roles.class);
        this.roleRepository.save(role);
        RoleResponse roleResponse = this.modelMapperManager
                .forResponses()
                .map(role, RoleResponse.class);
        return roleResponse;
    }

    @Override
    public RoleResponse delete(int id) {
        Roles role = roleRepository.findById(id).orElse(null);
        if (role == null) {
            throw new RuntimeException("Rol bulunamadı");
        }
        roleRepository.delete(role);
        RoleResponse roleResponse = this.modelMapperManager
                .forResponses()
                .map(role, RoleResponse.class);
        return roleResponse;
    }
}
