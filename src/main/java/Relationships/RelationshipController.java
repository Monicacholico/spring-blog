package Relationships;

import com.codeup.blog.Models.Post;
import com.codeup.blog.Models.User;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@ResponseBody
@Controller
public class RelationshipController {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public RelationshipController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/seed")
    public String seed() {

        User user = new User();
        user.setEmail("richard@email.com");
        user.setUsername("richard");
        user.setPassword("richardpassword");
        userRepository.save(user);

        List<Post> posts = Arrays.asList(
                new Post("the first one", "lorem"),
                new Post("the second one", "lorem"),
                new Post("third ad", "lorem"),
                new Post("the fourth one", "lorem")
        );

        for (Post post : posts) {
            post.setUser(user);
        }
        postRepository.save(posts);
        return "Check the console.";
    }

    // TODO: show all the ads for a given user
    @GetMapping("/example-profile")
    public String profile() {
        User user = userRepository.findOne(1l);

        System.out.println("Showing ads belonging to user " + user.getUsername());

        List<Post> posts = user.getPosts();

        for (Post post : posts) {
            System.out.println("  - " + post.getTitle());
        }

        return "Again, it's in the console.";
    }

    @GetMapping("/posts/show")
    public String show() {
        Post post = postRepository.findOne(1l);

        String username = (post.getUser().getEmail());
        postRepository.findOne(1l);
        System.out.println(username);

        return "/posts/show";
    }
}