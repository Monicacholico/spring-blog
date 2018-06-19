package com.codeup.blog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping ("/landingpage")
    public @ResponseBody String landingPage(){
        return "This is the landing page!";
    }

    @GetMapping("/home")
    public String showHomePage(){
        return "home";
    }

    @GetMapping("/portfolio")
    public String portfolio(){
        return "portfolio";
    }

//    @GetMapping("/rolldice")
//    public String rolldice(){ return "rolldice";}

}
