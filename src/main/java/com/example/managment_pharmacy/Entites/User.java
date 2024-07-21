package com.example.managment_pharmacy.Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class User {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 private String username;
 private String password;
 private String email;
 private String firstName;
 private String lastName;
 private String phoneNumber;
 private String address;
 private boolean enabled;
 private LocalDate dateOfBirth;

}
