package com.travel.prihanshTravel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travel.prihanshTravel.dto.UsersDTO;
import com.travel.prihanshTravel.service.UserService;
import com.travel.prihanshTravel.utility.Message;
import com.travel.prihanshTravel.utility.MessageType;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @Autowired
    private UserService userService;

    @GetMapping({ "/home", "/" })
    public String home(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/admin/login";
        }
        return "home";
    }

    @GetMapping("/about")
    public String about(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/admin/login";
        }
        return "about";
    }

    @GetMapping("/contact")
    public String contact(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/admin/login";
        }
        return "contact";
    }

    @GetMapping("/service")
    public String service(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/admin/login";
        }
        return "service";
    }    

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        userService.logout(session);
        Message message = new Message("You are successfully Logout!", MessageType.green);
        session.setAttribute("message", message);
        return "redirect:/admin/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        UsersDTO usersDTO = new UsersDTO();
        model.addAttribute("usersDTO", usersDTO);
        return "reg";
    }

    @GetMapping("/user/desktop")
    public String desktop(Model model) {
        model.addAttribute("name", "Prihansh");

        return "/user/desktop";
    }

    @GetMapping("/user/profile")
    public String profile(Model model) {
        model.addAttribute("name", "Prihansh");

        return "/user/profile";
    }

    @GetMapping("/login")
    public String login(Model model) {
        UsersDTO usersDTO = new UsersDTO();
        model.addAttribute("usersDTO", usersDTO);
        return "login";
    }

}
