package com.example.GroupProject_4.model.response;

import com.example.GroupProject_4.model.Entity.PostEntity;
import com.example.GroupProject_4.model.Entity.UserEntity;
import lombok.Data;

@Data
public class PostResponse {
    private Long id;
    private String content;
    private UserResponse owner;

    public static PostResponse from(PostEntity postEntity){
        PostResponse postDto = new PostResponse();
        postDto.setId(postEntity.getId());
        postDto.setContent(postEntity.getContent());
        postDto.setOwner(UserResponse.from(postEntity.getOwner()));
        return postDto;
    }
}
