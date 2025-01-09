package com.travel.prihanshTravel.dto;

import lombok.*;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsersDTO {

    @NotBlank(message = "First Name is mandatory")
    private String firstName;
    private String lastName;
    private Date userDob;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is invalid")
    private String userEmail;
    private String password;
    private String userImageUrl;
    @Size (min = 10, max = 10, message = "Phone number should be of 10 digits")
    private String userPhone;
    private String userGender;
    
    private String userRole; 
    private String userStatus;

}
