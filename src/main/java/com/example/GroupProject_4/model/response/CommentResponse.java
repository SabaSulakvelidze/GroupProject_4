package com.example.GroupProject_4.model.response;

import com.example.GroupProject_4.model.Entity.CommentEntity;
import com.example.GroupProject_4.model.Entity.PostEntity;
import lombok.Data;

@Data
public class CommentResponse {
    private Long id;
    private String text;
    private PostEntity post;
    private UserResponse owner;

    public static CommentResponse from(CommentEntity commentEntity){
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setId(commentEntity.getId());
        commentResponse.setText(commentEntity.getText());
        commentResponse.setPost(commentEntity.getPost());
        commentResponse.setOwner(UserResponse.from(commentEntity.getOwner()));
        return commentResponse;
    }
}
