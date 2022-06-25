package com.example.madrasabc.controller;



import com.example.madrasabc.dto.SubjectAllDto;
import com.example.madrasabc.dto.SubjectDto;
import com.example.madrasabc.dto.SubjectUtaadh;
import com.example.madrasabc.model.Subject;
import com.example.madrasabc.repository.SubjectRepository;
import com.example.madrasabc.service.SubjectService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("su")
@Data

public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectService subjectService;

    @GetMapping("subject")
    public List<SubjectAllDto> getAllSubjectModel(){
        return subjectService.getAllSubject();
    }


    @PostMapping("/s1")
    public void createSubject(@RequestBody SubjectDto subject){
        subjectService.addSubject(subject);
    }


    @GetMapping("/subject/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable long id){
        Subject subject= subjectRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(subject);
    }

    @PutMapping("/edit")
    public ResponseEntity<Subject> updatedSubject(@RequestBody Subject subjec){
        Subject updatedSubject = subjectRepository.save(subjec);
        return ResponseEntity.ok(updatedSubject);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        subjectRepository.deleteById(id);
    }

    @GetMapping("/subject/ustaadh")
    public List<SubjectUtaadh>getustadhnameSubject(){
        return subjectService.getsubjectname();
    }
}
