package com.travel.prihanshTravel.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersDTO {
    private String firstName;
    private String lastName;
    private Date userDob;
    private String userEmail;
    private String password;
    private String userImageUrl;
    private String userPhone;
    private String userGender;

}
