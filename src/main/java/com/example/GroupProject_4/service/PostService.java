package com.example.GroupProject_4.service;

import com.example.GroupProject_4.exception.ResourceNotFoundException;
import com.example.GroupProject_4.exception.UserPermissionException;
import com.example.GroupProject_4.model.entity.PostEntity;
import com.example.GroupProject_4.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
public class PostService {

    private PostRepository postRepository;

    public PostEntity createPost(PostEntity postEntity) {
        return postRepository.save(postEntity);
    }

    public Page<PostEntity> getAllPosts(Integer pageNumber, Integer pageSize, Sort.Direction direction, String sortBy) {
        return postRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(direction, sortBy)));
    }

    public Page<PostEntity> getAllPostsByUserId(Long userId, Integer pageNumber, Integer pageSize, Sort.Direction direction, String sortBy) {
        return postRepository.findAllPostsByUser(userId, PageRequest.of(pageNumber, pageSize, Sort.by(direction, sortBy)));
    }

    public PostEntity getPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id %d was not found".formatted(postId)));
    }

    public String deletePost(Long userId, Long postId) {
        PostEntity postById = getPostById(postId);
        if (!Objects.equals(postById.getOwner().getId(), userId))
            throw new UserPermissionException("User With id %d doesn't have permission for this action".formatted(userId));
        postRepository.delete(postById);
        return "Post with id %d was deleted".formatted(postId);
    }

    @Transactional
    public PostEntity editPost(Long postId, Long userId, PostEntity postEntity) {
        PostEntity postToEdit = getPostById(postId);
        if (!Objects.equals(postToEdit.getOwner().getId(), userId))
            throw new UserPermissionException("User With id %d doesn't have permission for this action".formatted(userId));
        postToEdit.setContent(postEntity.getContent());
        postToEdit.setOwner(postEntity.getOwner());
        return postToEdit;
    }
}
