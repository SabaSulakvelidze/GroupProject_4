package com.example.GroupProject_4.model.response;

import com.example.GroupProject_4.model.Entity.PostEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Long id;
    private String content;
    private String ownerName;

    public static PostResponse toPostResponse(PostEntity postEntity){
        PostResponse postDto = new PostResponse();
        postDto.setId(postEntity.getId());
        postDto.setContent(postEntity.getContent());
        postDto.setOwnerName(postEntity.getOwner().getUserName());
        return postDto;
    }
}
