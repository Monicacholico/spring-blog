package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


//        --------------- To see with Zack ----------------------------------
//        @RequestMapping(path = "/posts/index", method = RequestMethod.GET)
//            public String index (Model model){
//                List<String> posts = new ArrayList<>();
//                posts.add("This is my first post", "It's about anything");
//                posts.add("This is my second post");
//
//                model.addAttribute("posts", posts);
//                return "posts/index";
//
//            }

    @RequestMapping(path = "/posts/show", method = RequestMethod.GET)
    public String show (Model model){
//        Post post = new post(
//                post.getBody();
//                post.getTitle();
//       );
        return "posts/show";


// ----------------------- To see with Zach ------------------------------

//        @GetMapping("/posts")
//                public String index(Model view ){
//            view.addAtributte("posts", makeSomePosts())
//
//            return "postx/index";
//        }
//
//
//
//        private List <Post> makeSomePosts(){
//            return Arrays.asList(
//                    new Post ("Recipe", "this is the post")
//                    new Post ("Video", "this is a post with viedo")
//            )
//        }
    }



}
