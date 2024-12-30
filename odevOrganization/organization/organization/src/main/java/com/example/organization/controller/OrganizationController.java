package com.example.organization.controller;

import com.example.organization.business.abstracts.OrganizationService;
import com.example.organization.business.concretes.requests.CreateOrganizationRequests;
import com.example.organization.business.concretes.requests.UpdateOrganizationRequests;
import com.example.organization.business.concretes.responses.OrganizationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
    private final OrganizationService organizationService;
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/getall")
    public List<OrganizationResponse> getAll() {
        return organizationService.getAllOrganizations();
    }

    @GetMapping("/{id}")
    public OrganizationResponse getByID(int id) {
        return organizationService.getOrganizationById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(int id) {
        organizationService.deleteOrganization(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateOrganizationRequests updateOrganizationRequests) {
        organizationService.updateOrganization(updateOrganizationRequests);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateOrganizationRequests createOrganizationRequests) {
        this.organizationService.createOrganization(createOrganizationRequests);
    }
}
