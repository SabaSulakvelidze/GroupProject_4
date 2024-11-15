package com.example.GroupProject_4.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {
    private String text;
    private Long postId;
    private Long ownerId;
}
