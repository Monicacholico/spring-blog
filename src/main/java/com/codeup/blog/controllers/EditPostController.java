package com.codeup.blog.controllers;


import com.codeup.blog.services.PostService;
import org.springframework.stereotype.Controller;

@Controller
public class EditPostController {


    private final PostService postService;

    public EditPostController(PostService postService) {
        this.postService = postService;
    }


}
