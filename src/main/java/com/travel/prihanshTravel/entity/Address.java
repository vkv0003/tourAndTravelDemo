package com.travel.prihanshTravel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String street;
    private String type;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Users user;

}
