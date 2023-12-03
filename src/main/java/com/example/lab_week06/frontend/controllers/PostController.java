package com.example.lab_week06.frontend.controllers;

import com.example.lab_week06.backend.models.Post;
import com.example.lab_week06.backend.models.User;
import com.example.lab_week06.backend.repositories.PostRepository;
import com.example.lab_week06.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/show-home/{id}")
    public String showHome(ModelMap modelMap, @PathVariable Long id){
        modelMap.addAttribute("postList", postRepository.findAll());
        modelMap.addAttribute("authorID", id);
        return "home";
    }

    @GetMapping("/show-personal/{id}")
    public String showMyPost(ModelMap modelMap, @PathVariable Long id){
        List<Post> postList = postRepository.getPostsByAuthor_Id(id);
        modelMap.addAttribute("postPesonal", postList);
        modelMap.addAttribute("authorID", id);
        return "personal_post";
    }

   @GetMapping("/addPost/{id}")
    public String showFormAddPost(ModelMap modelMap ,@PathVariable Long id){
        Post post = new Post();
        modelMap.addAttribute("newPost", post);
        modelMap.addAttribute("userID", id);
        return "add_post";
   }

   @PostMapping("/addPost/{id}")
    public String addPost(ModelMap modelMap, @ModelAttribute("newPost") Post post, @ModelAttribute("userID") User user, @PathVariable Long id){
        user = userRepository.findUserById(id).get();
        System.out.println(user.getId());
        Post newPost = new Post(new User(user.getId()), post.getTitle(), post.getMetaTitle(), post.getSummary(), post.getPublished(),
                                LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), post.getContent());
        postRepository.save(newPost);
        return "redirect:/show-personal/" + user.getId();
   }

   @GetMapping("/deletePost/{postID}/{authorID}")
    public String deletePost(@PathVariable("postID") Long id, @PathVariable("authorID") Long authorID){
       Optional<Post> optionalPost = postRepository.findById(id);
       postRepository.delete(optionalPost.get());
       return "redirect:/show-personal/" + authorID;
   }
}
