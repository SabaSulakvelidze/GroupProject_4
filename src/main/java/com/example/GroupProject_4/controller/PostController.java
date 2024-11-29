package com.example.GroupProject_4.controller;

import com.example.GroupProject_4.model.entity.CommentEntity;
import com.example.GroupProject_4.model.entity.PostEntity;
import com.example.GroupProject_4.model.request.PostRequest;
import com.example.GroupProject_4.model.response.PostResponse;
import com.example.GroupProject_4.service.CommentService;
import com.example.GroupProject_4.service.PostService;
import com.example.GroupProject_4.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Posts")
@AllArgsConstructor
public class PostController {

    private PostService postService;
    private CommentService commentService;
    private UserService userService;

    @GetMapping("/GetAllPosts")
    public Page<PostResponse> getAllPosts(@RequestParam(defaultValue = "0") Integer pageNumber,
                                          @RequestParam(defaultValue = "5") Integer pageSize,
                                          @RequestParam(defaultValue = "ASC") Sort.Direction direction,
                                          @RequestParam(defaultValue = "id") String sortBy) {
        return postService.getAllPosts(pageNumber, pageSize, direction, sortBy).map(PostResponse::toPostResponse);
    }

    @GetMapping("/GetAllPostsByUserId")
    public Page<PostResponse> getAllPostsByUserId(@RequestParam Long ownerId,
                                                  @RequestParam(defaultValue = "0") Integer pageNumber,
                                                  @RequestParam(defaultValue = "5") Integer pageSize,
                                                  @RequestParam(defaultValue = "ASC") Sort.Direction direction,
                                                  @RequestParam(defaultValue = "id") String sortBy) {
        userService.getUserById(ownerId);
        return postService.getAllPostsByUserId(ownerId, pageNumber, pageSize, direction, sortBy).map(PostResponse::toPostResponse);
    }

    @GetMapping("/getSinglePost/{postId}")
    public PostResponse getPostById(@PathVariable Long postId) {
        return PostResponse.toPostResponse(postService.getPostById(postId));
    }

    @PostMapping("/CreateNewPost")
    public PostResponse createPost(@RequestBody @Valid PostRequest postRequest) {
        return PostResponse.toPostResponse(postService.createPost(PostEntity.toPostEntity(postRequest, userService.getUserById(postRequest.getOwnerId()))));
    }

    @PutMapping("/EditPost/{postId}")
    public PostResponse editPost(@PathVariable Long postId, @RequestParam Long userId, @RequestBody @Valid PostRequest postRequest) {
        return PostResponse.toPostResponse(postService.editPost(postId, userId, PostEntity.toPostEntity(postRequest, userService.getUserById(postRequest.getOwnerId()))));
    }

    @DeleteMapping("/Delete/{postId}")
    public String deletePost(@PathVariable Long postId, @RequestParam Long userId) {
        commentService.getAllCommentsByPostId(postId, 0, 100, Sort.Direction.ASC, "id")
                .getContent().forEach(c->commentService.deleteComment(c.getId()));
        return postService.deletePost(userId, postId);
    }
}
