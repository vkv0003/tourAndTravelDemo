package com.travel.prihanshTravel.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/admin")
public class AdminController {


    @GetMapping({"/home", "/"})
    public String home() {
        return "home";
    }

    @GetMapping("/desktop")
    public String desktop(Model model) {
        model.addAttribute("name", "Prihansh");

        return "desktop";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/service")
    public String service() {
        return "service";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

   
    

}
