package com.example.Roles.dataAccess.abstracts;

import com.example.Roles.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
}
