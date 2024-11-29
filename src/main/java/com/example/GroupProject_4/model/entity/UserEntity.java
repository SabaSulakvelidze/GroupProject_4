package com.example.GroupProject_4.model.entity;

import com.example.GroupProject_4.model.feignEntity.DataItem;
import com.example.GroupProject_4.model.feignEntity.ReqresUsersResponse;
import com.example.GroupProject_4.model.request.UserRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(unique = true)
    private String email;

    public static UserEntity toUserEntity(UserRequest userRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userRequest.getFirstName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setUserName(userRequest.getUserName());
        userEntity.setBirthDate(userRequest.getBirthDate());
        userEntity.setEmail(userRequest.getEmail());
        return userEntity;
    }
    public static UserEntity toUserEntity(DataItem dataItem){
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(dataItem.getFirstName());
        userEntity.setLastName(dataItem.getLastName());
        userEntity.setUserName(dataItem.getEmail());
        userEntity.setBirthDate(null);
        userEntity.setEmail(dataItem.getEmail());
        return userEntity;
    }
}
