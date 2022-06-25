package com.example.madrasabc.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
public class Ustaadh {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long ustaadh_id;



    private String firstName;

    private String lastName;
    private String middleName;
    private String place;
    private String nationality;
    private String gender;
    private int phone_number;
    private String email;
    private String password;
    private LocalDate dob;
    private int national_id;

    @OneToMany
    @JoinColumn(name = "ustaadh_id")
    private List<Subject> subjectList;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ustaadh_rol",
            joinColumns = @JoinColumn(name = "id"),
    inverseJoinColumns = @JoinColumn(name = "rolesId"))
    List<Roles>rolesList;

}
