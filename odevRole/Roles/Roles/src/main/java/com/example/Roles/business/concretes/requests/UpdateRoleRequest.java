package com.example.Roles.business.concretes.requests;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoleRequest {
    private int id;
    private String role_name;
    private String role_description;

    public String getRoleName() {
        return role_name;
    }

    public String getRoleDescription() {
        return role_description;
    }

    public int getId() {
        return id;
    }

    public void setRoleName(String role_name) {
        this.role_name = role_name;
    }

    public void setRoleDescription(String role_description) {
        this.role_description = role_description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
