package com.codeup.blog.controllers;

import com.codeup.blog.Models.Post;
import com.codeup.blog.Models.User;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class PostController {


    private final PostService postService;
    private final UserRepository userRepository;

    // PostController constructor
    // Dependency Injection
    public PostController(PostService postService, UserRepository userRepository) {
        this.postService = postService;
        this.userRepository = userRepository;
    }

    @GetMapping("/posts")
    public String index(Model view) {

        List<Post> posts = postService.findAll();

        view.addAttribute("posts", posts);

        // relative path for the .html file inside of resources/templates w/o the .html
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showDetails(@PathVariable long id, Model view){
        System.out.println("entro");
        Post post = postService.findOne(id);
        System.out.println(post.getUser().getEmail());
        view.addAttribute("post", post);


        return "posts/show";
    }



    @GetMapping("/posts/{id}/edit")
    public String edit (@PathVariable long id,  Model view){
        view.addAttribute("post", postService.findOne(id));
        return "/posts/edit";
    }



    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @Valid Post postDetails){
        System.out.println("updatePost");
        Post post = postService.findOne(id);
        post.setTitle(postDetails.getTitle());
        post.setBody(postDetails.getBody());
        postService.save(post);

                return "redirect:/posts";
    }

    @DeleteMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        postService.findOne(id);
        postService.deletePost(id);

        return "redirect:/posts";
    }



    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id){
        postService.delete(id);

        return "redirect:/posts";
    }



    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post
    ) {
        // save the post...

        post.setUser(userRepository.findOne(1L));
        postService.save(post);

        return "redirect:/posts";
    }


//    @RequestMapping(path = "/posts/show", method = RequestMethod.GET)
//    public String show (@ModelAttribute Post post
//       ){
//            return "posts/show";
//    }

//    @PostMapping("/ads/create")
//    public String create(
//            @RequestParam(name = "title") String title,
//            @RequestParam(name = "body") String body
//    ) {
//        Post post = new Post();
//        post.setTitle(title);
//        post.setBody(body);
//        // save the ad...
//    }


}


//    @RequestMapping(path = "/posts", method = RequestMethod.GET)
//    @ResponseBody
//    public String indexPost () {
//        return "This is your post ";
//    }

//        @GetMapping("/posts")
//        public @ResponseBody String post (){
//            return "Post Index page";
//        }
//
//
//    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public String postId (@PathVariable int id) {
//        return "Your post has the id : " + id + "!";
//    }


//    ------------ RYAN'S SOLUTION FOR SHOW POST PAGE --------------------------

//        @GetMapping ("/posts/{id}")
//        public String showDetails (@PathVariable long id, Model view){
//    Post post = new Post( " another post", "this is the body of that post");
//    view.addAtributte( "post", post);
//    return "posts/show";
//        }





//    @GetMapping("/posts")
//    public String index(Model view ){
//        List<Post> alistofPosts = makeSomePosts();
//        view.addAttribute("posts", alistofPosts);
//
//        return "/posts/index";
//    }

//        @GetMapping("/posts/create")
//    public@ResponseBody String createPost (){
//            return "View the form for creating a post";
//        }
//
//
//
//        @PostMapping("/posts/create")
//    public @ResponseBody String savePost(){
//        return "saving to the database...";
//        }
//
//    private List <Post> makeSomePosts(){
//        return Arrays.asList(
//                new Post ("Recipe", "this is the post"),
//                new Post ("Video", "this is a post with viedo")
//        );
//    }





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

//    @RequestMapping(path = "/posts/show", method = RequestMethod.GET)
//    public String show (Model model) {
//        Post post = new post(
//                post.getBody();
//                post.getTitle();
//       );
//        return "posts/show";
//
//    }
// ----------------------- To see with Zach ------------------------------


//
//
//


// --------------- How to add the css style? ---------------------------------
    // ------------- How to add the application to send text messages? -------


