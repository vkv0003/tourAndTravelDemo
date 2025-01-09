package com.travel.prihanshTravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.travel.prihanshTravel.dto.UsersDTO;
import com.travel.prihanshTravel.exception.TravelException;
import com.travel.prihanshTravel.service.UserService;
import com.travel.prihanshTravel.utility.Message;
import com.travel.prihanshTravel.utility.MessageType;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @PostMapping("/do-register")
    public ResponseEntity<String> registerUser(@ModelAttribute UsersDTO usersDTO, HttpSession session) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/prihanshTravel/admin/register");

        try {
            userService.registerUser(usersDTO);

            Message message = new Message("User registered successfully!", MessageType.green);
            session.setAttribute("message", message);
        } catch (TravelException e) {
            Message message = new Message(e.getMessage(), MessageType.red);
            session.setAttribute("message", message);
        }

        return new ResponseEntity<>("User registered successfully!", headers, HttpStatus.FOUND);
    }

    @PostMapping("/process-login")
    public String processLogin(@ModelAttribute UsersDTO usersDTO, HttpSession session, RedirectAttributes redirectAttributes) {

        try {
            userService.login(usersDTO, session);
            // Message message = new Message("User LoggedIn successfully!", MessageType.green);
            // session.setAttribute("message", message);
            return "redirect:/admin/home";
        } catch (TravelException travelException) {
            Message message = new Message(travelException.getMessage(), MessageType.red);
            session.setAttribute("message", message);
            return "redirect:/admin/login";
        }
    }
}
