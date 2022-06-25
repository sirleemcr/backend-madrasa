package com.example.madrasabc.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long rolesId;
    private String rolesName;
}
