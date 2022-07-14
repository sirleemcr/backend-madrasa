package com.example.madrasabc.controller;

import com.example.madrasabc.dto.ImtihaanAllDto;
import com.example.madrasabc.dto.ImtihaanDto;
import com.example.madrasabc.dto.Imtihaanbyustaadh;
import com.example.madrasabc.dto.Result;
import com.example.madrasabc.model.Imtihaan;
import com.example.madrasabc.repository.ImtihaanRepository;
import com.example.madrasabc.service.ImtihaanService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("i")
@Data

public class ImtihaanController {

    @Autowired
    private ImtihaanRepository imtihaanRepository;
    @Autowired
    private ImtihaanService imtihaanService;

    @GetMapping("imtihaan")
    public List<ImtihaanAllDto> getAllImtihaanModel(){
        return imtihaanService.getAllImtihaan();
    }


    @PostMapping("/i")
    public void createImtihaan(@RequestBody List<ImtihaanDto> imtihan){
        imtihaanService.addExamMark(imtihan);
    }


   @GetMapping("/imtihaan/{id}")
   public ResponseEntity<Imtihaan> getImtihaanById(@PathVariable long id){
        Imtihaan imtihaan = imtihaanRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(imtihaan);
  }

    @PutMapping("/edit")
    public ResponseEntity<Imtihaan> updatedImtihan(@RequestBody Imtihaan imtihaa){
        Imtihaan updatedImtihaan = imtihaanRepository.save(imtihaa);
        return ResponseEntity.ok(updatedImtihaan);

  }
  @GetMapping("byustaadh/{ustaadh_id}")
  public List<Result> getresult(@PathVariable("ustaadh_id") Long ustaadh_id) {
    return   imtihaanRepository.get(ustaadh_id);
  }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        imtihaanRepository.deleteById(id);
    }


    @GetMapping("/imt/{tilmydh_id}")
    public List<Result> getSubjectwithMarks(@PathVariable("tilmydh_id") Long tilmydh_id){
        return imtihaanService.getSudentSubject(tilmydh_id);
    }

    @GetMapping("im/tilmydh_id/{tilmydh_id}/fitrah_id/{fitrah_id}")
    public  List<Result> getResult(@PathVariable("tilmydh_id") Long tilmydh_id, @PathVariable("fitrah_id") Long fitrah_id){
        return imtihaanService.getSubjectStudent(tilmydh_id,fitrah_id);
    }
    @GetMapping("/imt/view")
    public List<Result> getResulty(){
        return  imtihaanService.getresult();
    }
}
