package com.example.GroupProject_4.model.response;

import com.example.GroupProject_4.model.entity.CommentEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private Long id;
    private String text;
    private String postOwnerName;
    private String commentOwnerName;

    public static CommentResponse toCommentResponse(CommentEntity commentEntity){
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setId(commentEntity.getId());
        commentResponse.setText(commentEntity.getText());
        commentResponse.setPostOwnerName(commentEntity.getPost().getOwner().getUserName());
        commentResponse.setCommentOwnerName(commentEntity.getOwner().getUserName());
        return commentResponse;
    }
}
