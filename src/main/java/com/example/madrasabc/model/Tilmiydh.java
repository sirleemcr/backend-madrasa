package com.example.madrasabc.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Table
@Entity
public class Tilmiydh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tilmydh_id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String place;
    private String nationality;
    private String gender;
    private Integer parent_number;
    private Long swaful_id;
    private String parent_name;
    private LocalDate Dob;
    @OneToMany
    @JoinColumn(name = "tilmydh_id")
    private List<Imtihaan> imtihaanList;

}
