package com.example.madrasabc.model;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class Swaful {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long swaful_id;
    private String swaful_name;
    @OneToMany
     @JoinColumn(name = "swaful_id")
     private List<Subject> subjectList;

     @OneToMany
     @JoinColumn(name="swaful_id")
     private List<Tilmiydh>tilmiydhList;
     @OneToMany
    @JoinColumn(name = "swaful_id")
    private List<Imtihaan>imtihaanList;

}
