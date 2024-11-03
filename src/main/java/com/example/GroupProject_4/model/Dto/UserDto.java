package com.example.GroupProject_4.model.Dto;

import com.example.GroupProject_4.model.Entity.UserEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String userName;

    private LocalDate birthDate;

    public static UserDto from(UserEntity userEntity){
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setUserName(userEntity.getUserName());
        userDto.setBirthDate(userEntity.getBirthDate());
        return userDto;
    }
}
