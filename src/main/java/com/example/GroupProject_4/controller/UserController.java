package com.example.GroupProject_4.controller;

import com.example.GroupProject_4.model.Dto.UserDto;
import com.example.GroupProject_4.model.Entity.UserEntity;
import com.example.GroupProject_4.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/GetAllUsers")
    public Page<UserDto> getAllUsers(@RequestParam(defaultValue = "0") Integer pageNumber,
                                       @RequestParam(defaultValue = "5") Integer pageSize,
                                       @RequestParam(defaultValue = "ASC") Sort.Direction direction,
                                       @RequestParam(defaultValue = "id") String sortBy) {
        return userService.getAllUsers(pageNumber, pageSize, direction, sortBy).map(UserDto::from);
    }

    @GetMapping("/getSingleUser/{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        return UserDto.from(userService.getUserById(userId));
    }

    @PostMapping("/RegisterNewUser")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return UserDto.from(userService.addNewUser(UserEntity.from(userDto)));
    }

    @PutMapping("/EditUser/{userId}")
    public UserDto editUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
        return UserDto.from(userService.editUser(userId, UserEntity.from(userDto)));
    }

    @DeleteMapping("/Delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}
