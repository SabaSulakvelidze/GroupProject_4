package com.example.GroupProject_4.model.response;

import com.example.GroupProject_4.model.Entity.UserEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private LocalDate birthDate;

    public static UserResponse from(UserEntity userEntity){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.getId());
        userResponse.setFirstName(userEntity.getFirstName());
        userResponse.setLastName(userEntity.getLastName());
        userResponse.setUserName(userEntity.getUserName());
        userResponse.setBirthDate(userEntity.getBirthDate());
        return userResponse;
    }
}
