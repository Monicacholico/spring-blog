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
        return "Your post has the id : " + id + "!";
    }

//        @GetMapping ("/posts/{id}")
//        public @ResponseBody int postsId (@PathVariable int id){
//            return id;
//        }

        @GetMapping("/posts/create")
    public@ResponseBody String createPost (){
            return "View the form for creating a post";
        }


        @GetMapping("/posts/{id}/edit")
    public @ResponseBody String edit (@PathVariable long id){
        return "View the form for eidting post # " + id;
        }

        @PostMapping("/posts/create")
    public @ResponseBody String savePost(){
        return "saving to the database...";
        }



}
