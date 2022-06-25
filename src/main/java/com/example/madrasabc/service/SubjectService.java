package com.example.madrasabc.service;

import com.example.madrasabc.dto.*;

import com.example.madrasabc.model.Subject;

import com.example.madrasabc.repository.SubjectRepository;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class SubjectService {
    private final ModelMapper mapper;
    private final SubjectRepository subjectRepository;

    public void addSubject(SubjectDto subjectDto) {
        Subject subject = mapper.map(subjectDto, Subject.class);
        subjectRepository.save(subject);
    }

    public List<SubjectAllDto> getAllSubject(){
        List<Subject> subjects = subjectRepository.findAll();
        List<SubjectAllDto> subjectDtos= new ArrayList<>();
        for (Subject subject:subjects) {
            subjectDtos.add(mapper.map(subject,SubjectAllDto.class));
        }
        return subjectDtos;}

    public  List<SubjectUtaadh>getsubjectname(){
        return subjectRepository.getUstaadhsubject();
    }
}
