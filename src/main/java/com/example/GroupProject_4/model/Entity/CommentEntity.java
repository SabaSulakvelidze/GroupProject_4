package com.example.GroupProject_4.model.Entity;

import com.example.GroupProject_4.model.request.CommentRequest;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private UserEntity owner;

    public static CommentEntity toCommentEntity(CommentRequest commentRequest, PostEntity postEntity, UserEntity userEntity){
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setText(commentRequest.getText());
        commentEntity.setPost(postEntity);
        commentEntity.setOwner(userEntity);
        return commentEntity;
    }

    public static CommentEntity toCommentEntity(CommentRequest commentRequest){
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setText(commentRequest.getText());
        return commentEntity;
    }
}
