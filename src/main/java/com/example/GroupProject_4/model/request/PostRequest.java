package com.example.GroupProject_4.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private String content;
    private Long ownerId;
}
