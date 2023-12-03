package com.example.lab_week06.backend.Test;

import com.example.lab_week06.backend.models.Post;
import com.example.lab_week06.backend.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TestPost {
    @Autowired
    static PostRepository postRepository ;
    public static void main(String[] args) {
        long id = 1;

    }
}
