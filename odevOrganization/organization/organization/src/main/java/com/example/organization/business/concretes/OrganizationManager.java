package com.example.organization.business.concretes;

import com.example.organization.business.abstracts.OrganizationService;
import com.example.organization.business.concretes.requests.CreateOrganizationRequests;
import com.example.organization.business.concretes.requests.UpdateOrganizationRequests;
import com.example.organization.business.concretes.responses.OrganizationResponse;
import com.example.organization.entities.PrivateOrganization;
import com.example.organization.mapper.abstracts.ModelMapperService;
import com.example.organization.dataAccess.abstracts.OrganizationRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class OrganizationManager implements OrganizationService {
    private  OrganizationRepository organizationRepository;
    private  ModelMapperService modelMapperService;


    public OrganizationManager(OrganizationRepository organizationRepository, ModelMapperService modelMapperService) {
        this.organizationRepository = organizationRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public OrganizationResponse createOrganization(CreateOrganizationRequests createOrganizationRequests) {
        PrivateOrganization organization = this.modelMapperService.forRequest().
                map(createOrganizationRequests,
                        PrivateOrganization.class);
        this.organizationRepository.save(organization);
        OrganizationResponse organizationResponse = this.modelMapperService.forResponses().
                map(organization, OrganizationResponse.class);
        return organizationResponse;
    }

    @Override
    public void deleteOrganization(int id) {
        this.organizationRepository.deleteById(id);
    }

    @Override
    public OrganizationResponse updateOrganization(UpdateOrganizationRequests updateOrganizationRequests) {
        PrivateOrganization organization = this.modelMapperService.forRequest().
                map(updateOrganizationRequests,
                        PrivateOrganization.class);
        this.organizationRepository.save(organization);
        OrganizationResponse organizationResponse = this.modelMapperService.forResponses().
                map(organization, OrganizationResponse.class);
        return organizationResponse;
    }

    @Override
    public OrganizationResponse getOrganizationById(int id) {
        PrivateOrganization organization = this.organizationRepository.findById(id).orElse(null);
        if (organization == null) {
            throw new RuntimeException("Organization not found");
        }
        OrganizationResponse organizationResponse = this.modelMapperService.forResponses().
                map(organization, OrganizationResponse.class);
        return organizationResponse;
    }

    @Override
    public List<OrganizationResponse> getAllOrganizations() {
        List<PrivateOrganization> organizations = this.organizationRepository.findAll();
        if (organizations.isEmpty()) {
            throw new RuntimeException("Organizations not found");
        }
        List<OrganizationResponse> organizationResponses = organizations.stream()
                .map(organization -> this.modelMapperService.forResponses().map(organization, OrganizationResponse.class))
                .collect(Collectors.toList());
        return organizationResponses;
    }
}
