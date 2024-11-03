package com.example.GroupProject_4.model.Entity;

import com.example.GroupProject_4.model.Dto.CommentDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity creator;

    public static CommentEntity from(CommentDto commentDto){
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setText(commentDto.getText());
        commentEntity.setPost(commentDto.getPost());
        commentEntity.setCreator(commentDto.getCreator());
        return commentEntity;
    }
}
