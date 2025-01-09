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
public class Users  {
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
    private boolean isUserLoggedIn;
    private boolean isEmailVerified;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     if (this.userRole == UserRole.ADMIN) {
    //         return Collections.singletonList(() -> "ROLE_ADMIN");
    //     }
    //     return Collections.emptyList();
    // }

    // @Override
    // public String getUsername() {
    //     return this.userEmail;
      
    // }




}
