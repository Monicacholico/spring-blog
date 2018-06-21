package com.codeup.blog.controllers;

import com.codeup.blog.repositories.PostRepository;
import org.springframework.stereotype.Controller;

@Controller
public class RepositoryPostController {
    private PostRepository repository;


    public RepositoryPostController(PostRepository repository) {
        this.repository = repository;

    }


}