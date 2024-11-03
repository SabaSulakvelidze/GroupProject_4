package com.example.GroupProject_4.repository;

import com.example.GroupProject_4.model.Entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    /*@Override
    Page<UserEntity> findAll(Pageable pageable);*/
}
