package com.codeup.blog;

import com.codeup.blog.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader){
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception {
        auth
                .userDetailsService(usersLoader)
                .passwordEncoder(passwordEncoder())
                ;
    }


    protected void configure (HttpSecurity httpSecurity) throws Exception{
        httpSecurity


                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/posts")
                .permitAll()

                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")

                .and()
                .authorizeRequests()
                .antMatchers("/", "/posts")
                .permitAll()

                .and()
                .authorizeRequests()
                .antMatchers(

                "/posts/create",
                "/posts/{id}/edit",
                "/posts/{id}/delete"
                )
                .authenticated()
                ;
    }


}
