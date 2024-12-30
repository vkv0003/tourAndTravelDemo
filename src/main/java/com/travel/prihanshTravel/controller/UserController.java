package com.travel.prihanshTravel.controller;

import com.travel.prihanshTravel.dto.UsersDTO;
import com.travel.prihanshTravel.exception.TravelException;
import com.travel.prihanshTravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UsersDTO> registerUser(UsersDTO usersDTO) throws TravelException {

        return new ResponseEntity<>(userService.registerUser(usersDTO), HttpStatus.CREATED);
    }

}
