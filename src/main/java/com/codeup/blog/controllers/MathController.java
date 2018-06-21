package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{x}/and/{y}")
    public @ResponseBody String addition (@PathVariable int x, @PathVariable int y){
        return String.valueOf(x + y);
    }



    @GetMapping ("/substract/{x}/and/{y}")
    public@ResponseBody String substract (@PathVariable int x, @PathVariable int y){
        return String.valueOf(x - y );

    }

    @GetMapping ("/multiply/{x}/and/{y}")
    public@ResponseBody String multiply (@PathVariable int x, @PathVariable int y){
        return String.valueOf(x * y );

    }

    @GetMapping ("/divide/{x}/and/{y}")
    public@ResponseBody String divide (@PathVariable int x, @PathVariable int y){
        return String.valueOf("The division of "+ x + " / " + y + " equals  = " + x / y );

    }


}
