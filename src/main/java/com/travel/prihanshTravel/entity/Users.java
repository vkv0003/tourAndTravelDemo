package com.travel.prihanshTravel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String firstName;
    private String lastName;
    private Date userDob;
    private String userEmail;
    private String password;
    private String userImageUrl;
    private String userPhone;
    private String userGender;
    private String createdBy;
    private LocalDate createdDate;
    private String updatedBy;
    private LocalDate updatedDate;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @Enumerated(EnumType.STRING)
    private UserType userType;

//    @OneToMany(mappedBy = "userAddress", cascade = CascadeType.ALL)
//    private List<Address> addressList;


}
