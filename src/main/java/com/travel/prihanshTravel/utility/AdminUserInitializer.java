package com.travel.prihanshTravel.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.travel.prihanshTravel.service.UserService;

@Configuration
public class AdminUserInitializer {

    @Autowired
    private UserService userService;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            System.out.println("From AdminUserInitializer");
            userService.autoRun();
        };
    }
}
