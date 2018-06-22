package com.codeup.blog.repositories;

import com.codeup.blog.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findOne(Long id);
}
