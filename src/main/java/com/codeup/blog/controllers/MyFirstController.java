package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyFirstController {

    @GetMapping("/say-hello")
    public @ResponseBody String myFirsSpringView(){
        return "Hello from Spring!";
    }


//    @GetMapping("/say-hello/{name}")
//    public @ResponseBody String sayHello (@PathVariable String name){
//        return String.format("Hello, %s!", name);
//    }

//    @GetMapping("/say-hello/{name}")
//    public @ResponseBody String sayHello (@PathVariable String name, Model model){
//        model.addAttribute("name", name);
//        return "hello";
//    }

    @GetMapping("/say-hello/{name}")
    public @ResponseBody String sayHello (Model model){
        List<String> languages = new ArrayList<>();
        languages.add("HTML5");
        languages.add("JAVA");
        languages.add("Javascript");
        languages.add("CSS");

        model.addAttribute("languages", languages);
        model.addAttribute("name", "World");
        return "hello";
    }

    @GetMapping("/flights/from//{from}/to/{to}")
    public @ResponseBody String getFlights(
            @PathVariable String from,
            @PathVariable String to
    ) {
        return String.format("Finding flights from %s to %s..", from, to);
    }


    @GetMapping("/say-goodbye")
    public @ResponseBody String mySecondSpringView(){
        return "Goodbye, World!";
    }


    @GetMapping ("/increment/{n}")
    public@ResponseBody String increment (@PathVariable int n){
        return String.format ("%d + 1 = %d", n, n + 1);

    }


}
