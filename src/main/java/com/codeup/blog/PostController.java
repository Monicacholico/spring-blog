package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
    public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String indexPost () {
        return "This is your post ";
    }

//        @GetMapping("/posts")
//        public @ResponseBody String post (){
//            return "Post Index page";
//        }
//
//
    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String postId (@PathVariable int id) {
        return "Your post has this: " + id + "!";
    }

//        @GetMapping ("/posts/{id}")
//        public @ResponseBody int postsId (@PathVariable int id){
//            return id;
//        }

        @GetMapping("/posts/create")
    public@ResponseBody String createPost (@PathVariable String newPost){
            return newPost;
        }


}
