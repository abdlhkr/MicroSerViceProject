package com.example.UserGroup.business.concretes;

import com.example.UserGroup.business.abstracts.UserGroupService;
import com.example.UserGroup.business.concretes.requests.CreateUserGroupRequests;
import com.example.UserGroup.business.concretes.requests.UpdateUserGroupRequests;
import com.example.UserGroup.business.concretes.responses.UserGroupResponses;
import com.example.UserGroup.dataAccess.UserGroupRepository;
import com.example.UserGroup.entities.UserGroup;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.UserGroup.mapper.concrete.ModelMapperManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class UserGroupManager implements UserGroupService {
    private UserGroupRepository userGroupRepository;
    private ModelMapperManager modelMapperManager;

    public UserGroupManager(UserGroupRepository userGroupRepository,ModelMapperManager modelMapperManager) {
        this.userGroupRepository = userGroupRepository;
        this.modelMapperManager = modelMapperManager;
    }
    @Override
    public List<UserGroupResponses> getAll() {
        List<UserGroup> userGroups = userGroupRepository.findAll();
        if (userGroups.isEmpty()) {
            throw new RuntimeException("Kullanıcı grubu bulunamadı");
        }
        List<UserGroupResponses> responses = userGroups.stream()
                .map(userGroup -> this.modelMapperManager.forResponses().map(userGroup, UserGroupResponses.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public UserGroupResponses getById(int id) {
        UserGroup userGroup = userGroupRepository.findById(id).orElse(null);
        if (userGroup == null) {
            throw new RuntimeException("Kullanıcı grubu bulunamadı");
        }
        UserGroupResponses userGroupResponses = this.modelMapperManager
                .forResponses()
                .map(userGroup, UserGroupResponses.class);
        return userGroupResponses;
    }

    @Override
    public UserGroupResponses add(CreateUserGroupRequests createUserGroupRequests) {
        UserGroup userGroup = this.modelMapperManager.forRequest()
                .map(createUserGroupRequests, UserGroup.class);
        this.userGroupRepository.save(userGroup);
        UserGroupResponses userGroupResponses = this.modelMapperManager
                .forResponses()
                .map(userGroup, UserGroupResponses.class);
        return userGroupResponses;
    }

    @Override
    public UserGroupResponses update(UpdateUserGroupRequests updateUserGroupRequests) {
        UserGroup userGroup = this.modelMapperManager.forRequest()
                .map(updateUserGroupRequests, UserGroup.class);
        this.userGroupRepository.save(userGroup);
        UserGroupResponses userGroupResponses = this.modelMapperManager
                .forResponses()
                .map(userGroup, UserGroupResponses.class);
        return userGroupResponses;
    }

    @Override
    public UserGroupResponses delete(int id) {
        UserGroup userGroup = userGroupRepository.findById(id).orElse(null);
        if (userGroup == null) {
            throw new RuntimeException("Kullanıcı grubu bulunamadı");
        }
        userGroupRepository.delete(userGroup);
        UserGroupResponses userGroupResponses = this.modelMapperManager
                .forResponses()
                .map(userGroup, UserGroupResponses.class);
        return userGroupResponses;
    }
}
