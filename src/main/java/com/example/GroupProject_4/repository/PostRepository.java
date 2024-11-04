package com.example.GroupProject_4.repository;

import com.example.GroupProject_4.model.Entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    @Query("""
            FROM PostEntity p
            WHERE p.owner.id = :ownerId
            """)
    Page<PostEntity> findAllPostsByUser(Long ownerId, PageRequest pageRequest);
}
