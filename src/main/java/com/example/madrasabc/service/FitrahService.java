package com.example.madrasabc.service;


import com.example.madrasabc.dto.FitrahAllDto;
import com.example.madrasabc.dto.FitrahDto;

import com.example.madrasabc.model.Fitrah;

import com.example.madrasabc.repository.FitrahRepository;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class FitrahService {
    private final ModelMapper mapper;
    private final FitrahRepository fitrahRepository;

    public void addFitrah(FitrahDto fitrahDto) {
        Fitrah fitrah = mapper.map(fitrahDto, Fitrah.class);
        fitrahRepository.save(fitrah);
    }

    public List<FitrahAllDto> getAllFitrah(){
        List<Fitrah> fitrahs = fitrahRepository.findAll();
        List<FitrahAllDto> fitrahDtos= new ArrayList<>();
        for (Fitrah fitrah:fitrahs) {
            fitrahDtos.add(mapper.map(fitrah,FitrahAllDto.class));
        }
        return fitrahDtos;}

}
