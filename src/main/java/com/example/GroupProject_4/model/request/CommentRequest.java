package com.example.GroupProject_4.model.request;

import lombok.Data;

@Data
public class CommentRequest {
    private String text;
    private Long postId;
    private Long ownerId;
}
