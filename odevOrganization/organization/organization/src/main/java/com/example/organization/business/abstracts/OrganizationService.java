package com.example.organization.business.abstracts;

import com.example.organization.business.concretes.requests.CreateOrganizationRequests;
import com.example.organization.business.concretes.requests.UpdateOrganizationRequests;
import com.example.organization.business.concretes.responses.OrganizationResponse;

import javax.print.attribute.standard.OrientationRequested;
import java.util.List;

public interface OrganizationService {
    OrganizationResponse createOrganization(CreateOrganizationRequests createOrganizationRequests);
    void deleteOrganization(int id);
    OrganizationResponse updateOrganization(UpdateOrganizationRequests updateOrganizationRequests);
    OrganizationResponse getOrganizationById(int id);
    List<OrganizationResponse> getAllOrganizations();
}
