package com.example.GroupProject_4.model.request;

import lombok.Data;

@Data
public class PostRequest {
    private String content;
    private Long ownerId;
}
