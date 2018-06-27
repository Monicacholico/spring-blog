package com.codeup.blog.repositories;

import com.codeup.blog.Models.Post;
import com.codeup.blog.Models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findByTitle(String title);

    List<Post> findById(Long id);


//    @Query(nativeQuery = true, value="SELECT * FROM posts WHERE title LIKE ?1 OR body LIKE ?1") // To insert any user without taking care of the id
//    User first();
}
