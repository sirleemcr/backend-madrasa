package com.example.madrasabc.controller;

import com.example.madrasabc.dto.FitrahAllDto;
import com.example.madrasabc.dto.FitrahDto;
import com.example.madrasabc.dto.ImtihaanAllDto;
import com.example.madrasabc.dto.ImtihaanDto;
import com.example.madrasabc.model.Fitrah;
import com.example.madrasabc.repository.FitrahRepository;
import com.example.madrasabc.repository.ImtihaanRepository;
import com.example.madrasabc.service.FitrahService;
import com.example.madrasabc.service.ImtihaanService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("f")
@Data

public class FitrahController {
    @Autowired
    private FitrahRepository fitrahRepository;
    @Autowired
    private FitrahService fitrahService;

    @GetMapping("fitrah")
    public List<FitrahAllDto> getAllFitrahModel(){
        return fitrahService.getAllFitrah();
    }


    @PostMapping("/f1")
    public void createFitrah(@RequestBody FitrahDto fitrah){
        fitrahService.addFitrah(fitrah);
    }


    @GetMapping("/fitrah/{id}")
    public ResponseEntity<Fitrah> getFitrahById(@PathVariable long id){
        Fitrah fitrah = fitrahRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(fitrah);
    }

    @PutMapping("/edit")
    public ResponseEntity<Fitrah> updatedFitrah(@RequestBody Fitrah fitra){
        Fitrah updatedFitrah = fitrahRepository.save(fitra);
        return ResponseEntity.ok(updatedFitrah);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        fitrahRepository.deleteById(id);
    }
}
