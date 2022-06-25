package com.example.madrasabc.controller;


import com.example.madrasabc.dto.*;
import com.example.madrasabc.model.Tilmiydh;
import com.example.madrasabc.repository.TilmiydhRepository;
import com.example.madrasabc.service.TilmiydhService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("t")
@Data
public class TilmiydhController {
    @Autowired
    private TilmiydhRepository tilmiydhRepository;
    @Autowired
    private TilmiydhService tilmiydhService;

    @GetMapping("tilmiydh")
    public List<TilmiydhAllDto> getAllTilmiydhtModel(){
        return tilmiydhService.getAllTilmiydh();
    }

    @GetMapping("/tilmy/swaful/{swaful_id}/subject/{subject_id}")
    public List<Joinexam>getAllTilmydhBySubject(@PathVariable("swaful_id") Long swaful_id , @PathVariable() Long subject_id){
        return tilmiydhService.getAllTilmiydhBysub(swaful_id,subject_id);
    }

    @GetMapping("/tilmy/swaful/{swaful_id}")
    public List<TilmiydhDtoa> getTimydgBYswaful(@PathVariable("swaful_id")Long swaful_id){
      return tilmiydhService.getTilmiydhByclass(swaful_id)  ;
    }
//    @GetMapping("/tilmy/tilmydh/{id}")
//    public List<TilmiydhDtoa> getTimydgBYID(@PathVariable()Long tilmydh_id){
//        return tilmiydhService.getTilmiydhById(tilmydh_id)  ;}

        @PostMapping("/t1")
    public void createTilmiydh(@RequestBody TilmiydhDto tilmiydh){
        tilmiydhService.addTilmiydh(tilmiydh);
    }


    @GetMapping("/tilmiydh/{id}")
    public ResponseEntity<Tilmiydh> getTilmiydhById(@PathVariable long id){
        Tilmiydh tilmiydh= tilmiydhRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(tilmiydh);
    }

    @PutMapping("/edit")
    public ResponseEntity<Tilmiydh> updatedTilmiydh(@RequestBody Tilmiydh tilmiyd){
        Tilmiydh updatedTilmiydh = tilmiydhRepository.save(tilmiyd);
        return ResponseEntity.ok(updatedTilmiydh);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        tilmiydhRepository.deleteById(id);
    }


    @GetMapping("/tilmy/swaful_id/{swaful_id}/subject_id/{subject_id}/ustaadh_id/{ustaadh_id}")
    public List<TilmydhUstaadh>getsubjctvsUstaadh(@PathVariable("swaful_id") Long swaful_id ,@PathVariable() Long subject_id ,@PathVariable() Long ustaadh_id){
        return  tilmiydhService.getStudentByUstaadh(swaful_id, subject_id, ustaadh_id);
    }
}
