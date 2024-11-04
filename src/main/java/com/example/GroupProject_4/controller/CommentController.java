package com.example.GroupProject_4.controller;

import com.example.GroupProject_4.model.Entity.CommentEntity;
import com.example.GroupProject_4.model.Entity.PostEntity;
import com.example.GroupProject_4.model.Entity.UserEntity;
import com.example.GroupProject_4.model.request.CommentRequest;
import com.example.GroupProject_4.model.response.CommentResponse;
import com.example.GroupProject_4.service.CommentService;
import com.example.GroupProject_4.service.PostService;
import com.example.GroupProject_4.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Comments")
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;
    private UserService userService;
    private PostService postService;

    @GetMapping("/GetAllComments")
    public Page<CommentResponse> getAllComments(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                @RequestParam(defaultValue = "5") Integer pageSize,
                                                @RequestParam(defaultValue = "ASC") Sort.Direction direction,
                                                @RequestParam(defaultValue = "id") String sortBy) {
        return commentService.getAllComment(pageNumber, pageSize, direction, sortBy).map(CommentResponse::from);
    }

    @GetMapping("/GetAllCommentsByPostId")
    public Page<CommentResponse> GetAllCommentsByPostId(@RequestParam Long postId,
                                                        @RequestParam(defaultValue = "0") Integer pageNumber,
                                                        @RequestParam(defaultValue = "5") Integer pageSize,
                                                        @RequestParam(defaultValue = "ASC") Sort.Direction direction,
                                                        @RequestParam(defaultValue = "id") String sortBy) {
        postService.getPostById(postId);
        return commentService.getAllCommentsByPostId(postId, pageNumber, pageSize, direction, sortBy).map(CommentResponse::from);
    }

    @GetMapping("/getSingleComment/{commentId}")
    public CommentResponse getPostById(@PathVariable Long commentId) {
        return CommentResponse.from(commentService.getCommentById(commentId));
    }

    @PostMapping("/CreateComment")
    public CommentResponse createComment(@RequestBody CommentRequest commentRequest) {
        PostEntity postEntity = postService.getPostById(commentRequest.getPostId());
        UserEntity userEntity = userService.getUserById(commentRequest.getOwnerId());
        return CommentResponse.from(commentService.createComment(CommentEntity.from(commentRequest,postEntity,userEntity)));
    }

    @PutMapping("/EditComment/{commentId}")
    public CommentResponse editComment(@PathVariable Long commentId, @RequestParam Long userId, @RequestBody CommentRequest commentRequest) {
        return CommentResponse.from(commentService.editComment(commentId,userId,CommentEntity.from(commentRequest)));
    }

    @DeleteMapping("/Delete/{commentId}")
    public String deletePost(@PathVariable Long commentId, @RequestParam Long userId) {
        return commentService.deleteComment(userId, commentId);
    }

}
