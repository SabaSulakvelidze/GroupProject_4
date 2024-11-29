package com.example.GroupProject_4.model.response;

import com.example.GroupProject_4.model.entity.UserEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private LocalDate birthDate;
    private String email;

    public static UserResponse toUserResponse(UserEntity userEntity){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.getId());
        userResponse.setFirstName(userEntity.getFirstName());
        userResponse.setLastName(userEntity.getLastName());
        userResponse.setUserName(userEntity.getUserName());
        userResponse.setBirthDate(userEntity.getBirthDate());
        userResponse.setEmail(userEntity.getEmail());
        return userResponse;
    }
}
