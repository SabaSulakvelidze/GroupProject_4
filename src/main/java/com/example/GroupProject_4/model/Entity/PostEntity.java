package com.example.GroupProject_4.model.Entity;

import com.example.GroupProject_4.model.Dto.PostDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private UserEntity owner;

    public static PostEntity from(PostDto postDto){
        PostEntity postEntity = new PostEntity();
        postEntity.setContent(postDto.getContent());
        postEntity.setOwner(postDto.getOwner());
        return postEntity;
    }
}
