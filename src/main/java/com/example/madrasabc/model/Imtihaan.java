package com.example.madrasabc.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table
public class Imtihaan {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private  double marks;
    private Long swaful_id;
    private Long tilmydh_id;
    private Long subject_id;

}
