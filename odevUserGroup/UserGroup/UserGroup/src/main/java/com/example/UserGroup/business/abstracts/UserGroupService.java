package com.example.UserGroup.business.abstracts;

import com.example.UserGroup.business.concretes.requests.CreateUserGroupRequests;
import com.example.UserGroup.business.concretes.requests.UpdateUserGroupRequests;
import com.example.UserGroup.business.concretes.responses.UserGroupResponses;

import java.util.List;

public interface UserGroupService {
    List<UserGroupResponses> getAll();
    UserGroupResponses getById(int id);
    UserGroupResponses add(CreateUserGroupRequests createUserGroupRequests);
    UserGroupResponses update(UpdateUserGroupRequests updateUserGroupRequests);
    UserGroupResponses delete(int id);
}
