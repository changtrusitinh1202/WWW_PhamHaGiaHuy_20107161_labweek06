package com.example.lab_week06.frontend.controllers;

import com.example.lab_week06.backend.models.User;
import com.example.lab_week06.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/loginUser")
    public String login(@RequestParam("Email")String email, @RequestParam("Password") String password, ModelMap modelMap){
        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        if(optionalUser.isPresent()){
            if(optionalUser.get().getPassword().equals(password)){
                modelMap.addAttribute("userID", optionalUser.get().getId());
                return "redirect:/show-home/" + optionalUser.get().getId();
            }

        }
        modelMap.addAttribute("loginFail", "Đăng nhập thất bại");
        return "login";
    }

    @GetMapping("/show-login")
    public String showFormLogin(){
        return "login";
    }

    @GetMapping("/show-register")
    public String showFormSignUp(ModelMap modelMap){
        User user = new User();
        modelMap.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/insertUser")
    public String addUser(ModelMap modelMap, @ModelAttribute("user") User user){
        userRepository.save(user);
        return "login";
    }



}
