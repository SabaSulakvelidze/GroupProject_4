package com.example.GroupProject_4.model.Entity;

import com.example.GroupProject_4.model.request.PostRequest;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public static PostEntity toPostEntity(PostRequest postRequest, UserEntity userEntity){
        PostEntity postEntity = new PostEntity();
        postEntity.setContent(postRequest.getContent());
        postEntity.setOwner(userEntity);
        return postEntity;
    }
}
