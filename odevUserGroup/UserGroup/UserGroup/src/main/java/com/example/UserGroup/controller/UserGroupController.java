package com.example.UserGroup.controller;

import com.example.UserGroup.business.abstracts.UserGroupService;
import com.example.UserGroup.business.concretes.requests.CreateUserGroupRequests;
import com.example.UserGroup.business.concretes.requests.UpdateUserGroupRequests;
import com.example.UserGroup.business.concretes.responses.UserGroupResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usergroup")
public class UserGroupController {
    private UserGroupService userGroupService;
    @Autowired
    public UserGroupController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @GetMapping("/getall")
    public List<UserGroupResponses> getAll() {
        return userGroupService.getAll();
    }

    @GetMapping("/{id}")
    public UserGroupResponses getById(int id) {
        return userGroupService.getById(id);
    }

    @PostMapping("/add")
    public UserGroupResponses add(CreateUserGroupRequests createUserGroupRequests) {
        return userGroupService.add(createUserGroupRequests);
    }

    @PutMapping("/update")
    public UserGroupResponses update(UpdateUserGroupRequests updateUserGroupRequests) {
        return userGroupService.update(updateUserGroupRequests);
    }

    @DeleteMapping("/delete")
    public UserGroupResponses delete(int id) {
        return userGroupService.delete(id);
    }

}
