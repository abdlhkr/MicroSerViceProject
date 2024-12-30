package com.example.Permission.controller;

import com.example.Permission.business.abstracts.PermissionService;
import com.example.Permission.business.concretes.requests.CreatePermissionRequest;
import com.example.Permission.business.concretes.requests.UpdatePermissionRequest;
import com.example.Permission.business.concretes.responses.PermissionResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/permissions")
public class PermissionController {
    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("/getall")
    public List<PermissionResponses> getAll() {
        return permissionService.getAllPermission();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        permissionService.deletePermission(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdatePermissionRequest updatePermissionRequest) {
        permissionService.updatePermission(updatePermissionRequest);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreatePermissionRequest createPermissionRequest) {
        permissionService.addPermission(createPermissionRequest);
    }

    @GetMapping("/{id}")
    public PermissionResponses getByID(@PathVariable int id) {
        return permissionService.getPermissionById(id);
    }
}
