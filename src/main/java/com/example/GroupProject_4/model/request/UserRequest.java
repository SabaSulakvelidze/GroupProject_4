package com.example.GroupProject_4.model.request;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class UserRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private LocalDate birthDate;


}
