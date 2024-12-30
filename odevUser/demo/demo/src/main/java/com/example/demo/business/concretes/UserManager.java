package com.example.demo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.business.abstracts.UserService;
import com.example.demo.business.concretes.requests.CreateUserRequest;
import com.example.demo.business.concretes.requests.UpdateUserRequest;
import com.example.demo.business.concretes.responses.UserResponse;
import com.example.demo.dataAcess.abstracts.UserRepository;
import com.example.demo.entities.concretes.User;
import com.example.demo.mapper.concrete.ModelMapperManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final ModelMapperManager modelMapperManager;

    public UserManager(UserRepository userRepository, ModelMapperManager modelMapperManager) {
        this.userRepository = userRepository;
        this.modelMapperManager = modelMapperManager;
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return List.of(); // Boş bir liste döndür
        }
        return users.stream()
                .map(user -> this.modelMapperManager.forResponses().map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse add(CreateUserRequest createUserRequest) {
        User user = this.modelMapperManager.forRequest()
                .map(createUserRequest, User.class);
        this.userRepository.save(user);
        UserResponse userResponse = this.modelMapperManager
                .forResponses()
                .map(user, UserResponse.class);
        return userResponse;
    }

    @Override
    public UserResponse getByID(int id) {
        User user = userRepository.findById(id).orElse(null);
        UserResponse userResponse = this.modelMapperManager
                .forResponses()
                .map(user, UserResponse.class);
        return userResponse;
    }

    @Override
    public UserResponse update(UpdateUserRequest updateUserRequest) {
        User user = this.modelMapperManager.forRequest()
                .map(updateUserRequest, User.class);
        this.userRepository.save(user);
        UserResponse userResponse = this.modelMapperManager
                .forResponses()
                .map(user, UserResponse.class);
        return userResponse;
    }

    @Override
    public UserResponse delete(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        userRepository.delete(user);
        UserResponse userResponse = this.modelMapperManager
                .forResponses()
                .map(user, UserResponse.class);
        return userResponse;
    }
}
