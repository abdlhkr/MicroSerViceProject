package com.example.demo.business.abstracts;

import com.example.demo.business.concretes.requests.CreateUserRequest;
import com.example.demo.business.concretes.requests.UpdateUserRequest;
import com.example.demo.business.concretes.responses.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAll();
    UserResponse add(CreateUserRequest createUserRequest);
    UserResponse getByID(int id);
    UserResponse update(UpdateUserRequest updateUserRequest);
    UserResponse delete(int id);
}
