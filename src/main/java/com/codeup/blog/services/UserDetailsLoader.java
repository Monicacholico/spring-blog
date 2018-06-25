package com.codeup.blog.services;

import com.codeup.blog.Models.User;
import com.codeup.blog.Models.UserwithRoles;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService{

    private final UserRepository userRepository;

    public UserDetailsLoader (UserRepository userRepository){
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{

        User user = userRepository.findByUsername(username);
        if ( user == null) {
            throw new UsernameNotFoundException("couldn't find user w/ username" + username);

        }
        return new UserwithRoles(user);
    }
}
