package com.example.Roles.controller;

import com.example.Roles.business.abstracts.RoleService;
import com.example.Roles.business.concretes.requests.CreateRoleRequest;
import com.example.Roles.business.concretes.requests.UpdateRoleRequest;
import com.example.Roles.business.concretes.responses.RoleResponse;
import com.example.Roles.entities.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;
    @Autowired // bu annotation sayesinde spring arka planda bir obje oluşturup buraya enjekte eder
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping("/getall")
    public List<RoleResponse> getAll() {
        return roleService.getAll();
    }
    @GetMapping("/{id}")
    public RoleResponse getByID(@PathVariable int id) {
        return roleService.getByID(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        roleService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateRoleRequest updateRoleRequest) {
        roleService.update(updateRoleRequest);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add( CreateRoleRequest createRoleRequest) {
        this.roleService.add(createRoleRequest);
    }
}
