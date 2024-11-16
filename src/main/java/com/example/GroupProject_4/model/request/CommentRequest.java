package com.example.GroupProject_4.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {
    @NotBlank(message = "text can not be empty")
    @Size(min = 2,max = 128, message = "text size must be between 2-128 characters")
    private String text;
    private Long postId;
    private Long ownerId;
}
