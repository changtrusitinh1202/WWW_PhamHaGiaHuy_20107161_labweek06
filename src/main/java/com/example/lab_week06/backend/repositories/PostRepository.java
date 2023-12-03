package com.example.lab_week06.backend.repositories;

import com.example.lab_week06.backend.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> getPostsByAuthor_Id(Long id);
    List<Post> findPostByParentId(long parentID);
}