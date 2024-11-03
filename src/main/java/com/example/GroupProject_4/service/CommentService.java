package com.example.GroupProject_4.service;

import com.example.GroupProject_4.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CommentService {

    private CommentRepository commentRepository;
}
