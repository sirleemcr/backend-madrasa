package com.example.madrasabc.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class TilmiydhDto {
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

}
