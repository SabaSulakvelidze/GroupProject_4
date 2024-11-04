package com.example.GroupProject_4.model.Entity;

import com.example.GroupProject_4.model.request.UserRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String userName;

    private LocalDate birthDate;

    public static UserEntity from(UserRequest userRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userRequest.getFirstName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setUserName(userRequest.getUserName());
        userEntity.setBirthDate(userRequest.getBirthDate());
        return userEntity;
    }
}
