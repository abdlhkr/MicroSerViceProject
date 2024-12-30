package com.example.Permission.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Permission.entities.concretes.PermissonEntity;


public interface PermissionRepository extends JpaRepository<PermissonEntity, Integer> {
}
