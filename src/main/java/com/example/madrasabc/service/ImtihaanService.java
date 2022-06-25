package com.example.madrasabc.service;

import com.example.madrasabc.dto.*;
import com.example.madrasabc.model.Imtihaan;
import com.example.madrasabc.model.Swaful;
import com.example.madrasabc.repository.ImtihaanRepository;
import com.example.madrasabc.repository.SwafulRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Data
public class ImtihaanService {
    private final ModelMapper mapper;
    private final ImtihaanRepository imtihaanRepository;


    public void addExamMark(List<ImtihaanDto>imtihaanDto){
        for (ImtihaanDto imth : imtihaanDto){
//              //add imtihaan
            Imtihaan imtihaan=mapper.map(imth,Imtihaan.class);
//            imtihaan.setId();
            imtihaanRepository.save(imtihaan);
        }
    }

    public List<ImtihaanAllDto> getAllImtihaan(){
        List<Imtihaan> imtihaans = imtihaanRepository.findAll();
        List<ImtihaanAllDto> imtihaanDtos= new ArrayList<>();
        for (Imtihaan imtihaan:imtihaans) {
            imtihaanDtos.add(mapper.map(imtihaan,ImtihaanAllDto.class));
        }
        return imtihaanDtos;
    }


    public List<Result> getSudentSubject(Long tilmydh_id){
         return imtihaanRepository.getSubjectbyMarks(tilmydh_id);
    }

    public List<Result> getSubjectStudent(Long tilmydh_id ,Long fitrah_id){
        return imtihaanRepository.geStudentsMarks(tilmydh_id,fitrah_id);
    }
    public List<Result>getresult(){
        return  imtihaanRepository.getRes();
    }
}
