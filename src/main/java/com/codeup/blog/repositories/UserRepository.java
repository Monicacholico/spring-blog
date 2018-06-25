package com.codeup.blog.repositories;

import com.codeup.blog.Models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findOne(Long id);

    User findById(Long id);

    User findByUsername(String name);

    @Query(nativeQuery = true, value="SELECT * FROM user LIMIT 1") // To insert any user without taking care of the id
    User first();
//    With this method you make sure you pass this method in your post Controller eather on your create or in your save method.


}
