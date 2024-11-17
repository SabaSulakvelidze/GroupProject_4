package com.example.GroupProject_4.controller;

import com.example.GroupProject_4.model.Entity.UserEntity;
import com.example.GroupProject_4.model.request.UserRequest;
import com.example.GroupProject_4.model.response.UserResponse;
import com.example.GroupProject_4.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Users")
@AllArgsConstructor
@Tag(name = "Users API", description = "Endpoints for Users")
public class UserController {

    private UserService userService;

    @GetMapping("/GetAllUsers")
    @Operation(summary = "Get Example", description = "This endpoint provides an example response")
    public Page<UserResponse> getAllUsers(
            @Parameter(
                    description = "Page number for pagination",
                    example = "0",
                    schema = @Schema(type = "integer", minimum = "0")
            )
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @Parameter(
                    description = "Number of users per page",
                    example = "5",
                    schema = @Schema(type = "integer", minimum = "1", maximum = "100")
            )
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
