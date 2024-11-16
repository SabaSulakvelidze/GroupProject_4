package com.example.GroupProject_4.controller;

import com.example.GroupProject_4.model.Entity.UserEntity;
import com.example.GroupProject_4.model.request.UserRequest;
import com.example.GroupProject_4.model.response.UserResponse;
import com.example.GroupProject_4.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/GetAllUsers")
    public Page<UserResponse> getAllUsers(@RequestParam(defaultValue = "0") Integer pageNumber,
                                          @RequestParam(defaultValue = "5") Integer pageSize,
                                          @RequestParam(defaultValue = "ASC") Sort.Direction direction,
                                          @RequestParam(defaultValue = "id") String sortBy) {
        return userService.getAllUsers(pageNumber, pageSize, direction, sortBy).map(UserResponse::toUserResponse);
    }

    @GetMapping("/getSingleUser/{userId}")
    public UserResponse getUserById(@PathVariable Long userId) {
        return UserResponse.toUserResponse(userService.getUserById(userId));
    }

    @PostMapping("/CreateUser")
    public UserResponse createUser(@RequestBody @Valid UserRequest userRequest) {
        return UserResponse.toUserResponse(userService.addNewUser(UserEntity.toUserEntity(userRequest)));
    }

    @PutMapping("/EditUser/{userId}")
    public UserResponse editUser(@PathVariable Long userId, @RequestBody @Valid UserRequest userRequest) {
        return UserResponse.toUserResponse(userService.editUser(userId, UserEntity.toUserEntity(userRequest)));
    }

    @DeleteMapping("/Delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}
