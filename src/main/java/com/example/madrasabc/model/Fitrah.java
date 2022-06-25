package com.example.madrasabc.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Table
@Entity
public class Fitrah {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fitrah_name;
    private String year;
    @OneToMany
    @JoinColumn(name="fitrah_id")
    private List<Subject> subjectList;
}
