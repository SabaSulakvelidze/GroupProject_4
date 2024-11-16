package com.example.GroupProject_4.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    @NotBlank(message = "content can not be empty")
    @Size(min = 2,max = 512, message = "content size must be between 2-512 characters")
    private String content;
    private Long ownerId;
}
