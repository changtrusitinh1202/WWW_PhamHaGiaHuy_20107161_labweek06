package com.example.lab_week06.backend.repositories;

import com.example.lab_week06.backend.models.Post;
import com.example.lab_week06.backend.models.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {

}