package com.example.Roles.entities;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "role_name")
    private String role;
    @Column(name = "role_description")
    private String role_description;

    public String getRoleName() {
        return role;
    }

    public String getRoleDescription() {
        return role_description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoleName(String role) {
        this.role = role;
    }

    public void setRoleDescription(String role_description) {
        this.role_description = role_description;
    }
}
