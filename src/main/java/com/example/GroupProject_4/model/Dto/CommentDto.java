package com.example.GroupProject_4.model.Dto;

import com.example.GroupProject_4.model.Entity.CommentEntity;
import com.example.GroupProject_4.model.Entity.PostEntity;
import com.example.GroupProject_4.model.Entity.UserEntity;
import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String text;
    private PostEntity post;
    private UserEntity creator;

    public static CommentDto from(CommentEntity commentEntity){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(commentEntity.getId());
        commentDto.setText(commentEntity.getText());
        commentDto.setPost(commentEntity.getPost());
        commentDto.setCreator(commentEntity.getCreator());
        return commentDto;
    }
}
