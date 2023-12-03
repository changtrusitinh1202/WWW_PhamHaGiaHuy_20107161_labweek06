package com.example.lab_week06.backend.services;

import com.example.lab_week06.backend.models.User;
import com.example.lab_week06.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

//    @GetMapping("/account")
//    public String login(){
//        Optional<User> optionalUser = userRepository.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
//        return optionalUser == null ? "/hi" : "/home";
//        return "/home";
//    }
}
