package com.example.GroupProject_4.repository;

import com.example.GroupProject_4.model.Entity.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

    @Query("""
            FROM CommentEntity c
            WHERE c.post.id = :postId
            """)
    Page<CommentEntity> findAllCommentsByPostId(Long postId, PageRequest pageRequest);
}
