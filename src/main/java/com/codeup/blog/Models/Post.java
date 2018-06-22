package com.codeup.blog.Models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id @GeneratedValue
    private long id;

    @Column(name = "the_title_of_the_post", nullable = false)
    private String title;

    @Column(name = "the_detail_of_the_body", nullable = false, columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;


    public Post(){}

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }


    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



}
