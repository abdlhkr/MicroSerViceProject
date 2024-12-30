package com.example.organization.dataAccess.abstracts;

import com.example.organization.entities.PrivateOrganization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<PrivateOrganization, Integer> {
}
