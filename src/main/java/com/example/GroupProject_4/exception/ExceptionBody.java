package com.example.GroupProject_4.exception;


import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionBody {
    private List<String> messages;
    private String endpoint;
    private LocalDateTime timeStamp;
    private String httpStatusCode;
}
