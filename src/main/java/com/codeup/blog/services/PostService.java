package com.codeup.blog.services;

import com.codeup.blog.Models.Post;
import com.codeup.blog.Models.User;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }


    public List<Post> findAll() {
        Iterable<Post> posts = postRepository.findAll();
        return (List<Post>) posts;
    }

    public Post save(Post post) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findById(sessionUser.getId());
        post.setUser(user);
        postRepository.save(post);
        return post;
    }

    public Post findOne(long id) {
        Post post = postRepository.findOne(id);
        return post;
    }

    public Post deletePost (long id){
        postRepository.delete(id);
        return deletePost(id);
    }

    public void delete (long id){
        postRepository.delete(id);
    }

}