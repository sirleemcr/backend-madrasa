package com.example.madrasabc.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table
public class Subject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String subject_name;

    private Long ustaadh_id;
    private Long fitrah_id;
    private Long swaful_id;
    @OneToMany
    @JoinColumn(name = "subject_id")
    private List<Imtihaan> imtihaanList;
}
