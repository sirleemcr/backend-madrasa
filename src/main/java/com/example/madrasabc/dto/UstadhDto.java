package com.example.madrasabc.dto;


import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Data
public class UstadhDto {
    private int phone_number;
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private String place;
    private String nationality;
    private String gender;
    private String password;
    private long rolesId;


}
