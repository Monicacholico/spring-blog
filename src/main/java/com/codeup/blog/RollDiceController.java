package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class RollDiceController {


    @GetMapping("/rolldice")
    public String showGame() {
        return "rolldice";
    }

    @GetMapping("/rolldice/{guess}")
    public String play(@PathVariable int guess, Model model) {
        int rnd = (int )(Math.random() * 6 + 1);
        boolean res = (guess == rnd);
        model.addAttribute("result", res);
        model.addAttribute("number", rnd);
        return "dicerolled";
    }

//    @GetMapping("/rolldice/{number}")
//    public String rolldicePage(@PathVariable int number) {
//        number = 6;
//        Random r = new Random();
//        for (int i = 0; i < number; i++) {
//            System.out.println("Roll is:  " + number);
//            number += number;
//        }
//        return rolldicePage(number);
//    }
//}




}

//@GetMapping("/say-hello/{name}")
//    public @ResponseBody String sayHello (@PathVariable String name, Model model){
//        model.addAttribute("name", name);
//        return "hello";
//    }