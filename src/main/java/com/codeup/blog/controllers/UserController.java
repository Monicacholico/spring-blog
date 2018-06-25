package com.codeup.blog.controllers;

import com.codeup.blog.Models.User;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    public UserController (UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/sign-up")
    public String showSignupForm (Model model){
        model.addAttribute("user", new User());
        System.out.println("this is a test");
        return "users/sign-up";
    }


    @PostMapping("/sign-up")
    public String saveUser (@ModelAttribute User user){
    String hash = passwordEncoder.encode(user.getPassword());
    user.setPassword(hash);
    userRepository.save(user);
    return "redirect:/login";
    }

}
