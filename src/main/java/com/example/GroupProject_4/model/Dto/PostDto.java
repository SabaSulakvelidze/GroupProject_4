package com.example.GroupProject_4.model.Dto;

import com.example.GroupProject_4.model.Entity.PostEntity;
import com.example.GroupProject_4.model.Entity.UserEntity;
import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String content;
    private UserEntity owner;

    public static PostDto from(PostEntity postEntity){
        PostDto postDto = new PostDto();
        postDto.setId(postEntity.getId());
        postDto.setContent(postEntity.getContent());
        postDto.setOwner(postEntity.getOwner());
        return postDto;
    }
}
