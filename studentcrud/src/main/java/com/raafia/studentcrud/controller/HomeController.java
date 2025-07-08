package com.raafia.studentcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        System.out.println("Inside home navigation .");
        return "index"; // renders templates/index.html
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
