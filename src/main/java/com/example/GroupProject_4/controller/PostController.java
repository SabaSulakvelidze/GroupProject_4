package com.example.GroupProject_4.controller;

import com.example.GroupProject_4.model.Dto.PostDto;
import com.example.GroupProject_4.model.Entity.PostEntity;
import com.example.GroupProject_4.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Posts")
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @GetMapping("/GetAllPosts")
    public Page<PostDto> getAllPosts(@RequestParam(defaultValue = "0") Integer pageNumber,
                                     @RequestParam(defaultValue = "5") Integer pageSize,
                                     @RequestParam(defaultValue = "ASC") Sort.Direction direction,
                                     @RequestParam(defaultValue = "id") String sortBy) {
        return postService.getAllPosts(pageNumber, pageSize, direction, sortBy).map(PostDto::from);
    }

    @GetMapping("/GetAllPostsByUserId/{ownerId}")
    public Page<PostDto> getAllPostsByUserId(@PathVariable Long ownerId,
                                             @RequestParam(defaultValue = "0") Integer pageNumber,
                                             @RequestParam(defaultValue = "5") Integer pageSize,
                                             @RequestParam(defaultValue = "ASC") Sort.Direction direction,
                                             @RequestParam(defaultValue = "id") String sortBy) {
        return postService.getAllPostsByUserId(ownerId, pageNumber, pageSize, direction, sortBy).map(PostDto::from);
    }

    @GetMapping("/getSinglePost/{userId}")
    public PostDto getPostById(@PathVariable Long userId) {
        return PostDto.from(postService.getPostById(userId));
    }

    @PostMapping("/CreateNewPost")
    public PostDto createPost(@RequestBody PostDto postdto) {
        return PostDto.from(postService.createPost(PostEntity.from(postdto)));
    }

    @PutMapping("/EditPost/{userId}")
    public PostDto editPost(@RequestParam Long userId, @PathVariable Long postId, @RequestBody PostDto postdto) {
        return PostDto.from(postService.editPost(userId, postId, PostEntity.from(postdto)));
    }

    @DeleteMapping("/Delete/{userId}")
    public String deletePost(@RequestParam Long userId, @PathVariable Long postId) {
        return postService.deletePost(userId, postId);
    }
}
