package com.example.demo.controller;

import com.example.demo.business.abstracts.UserService;
import com.example.demo.business.concretes.requests.CreateUserRequest;
import com.example.demo.business.concretes.requests.UpdateUserRequest;
import com.example.demo.business.concretes.responses.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/getall")
    public List<UserResponse> getAll() {
        return userService.getAll();
    }
    @DeleteMapping("/id")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public UserResponse delete(int id) {
        return userService.delete(id);
    }
    @GetMapping("/{id}")
    public UserResponse getByID(@PathVariable int id) {
        return userService.getByID(id);
    }
    // update için put kullanılır
    @PutMapping("/update")
    public UserResponse update(@RequestBody UpdateUserRequest user) {
        return userService.update(user);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserResponse add(@RequestBody CreateUserRequest user) {
        return userService.add(user);
    }

}
