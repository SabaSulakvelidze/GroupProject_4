package com.example.GroupProject_4.repository;

import com.example.GroupProject_4.model.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity,Long> {
}
