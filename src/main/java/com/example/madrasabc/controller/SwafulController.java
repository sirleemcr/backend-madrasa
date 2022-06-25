package com.example.madrasabc.controller;

import com.example.madrasabc.dto.SwafulDto;
import com.example.madrasabc.dto.SwafullAllDto;
import com.example.madrasabc.model.Swaful;
import com.example.madrasabc.repository.SwafulRepository;
import com.example.madrasabc.service.SwafulServices;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("s")
@Data
public class SwafulController {
    @Autowired
    private  SwafulRepository swafulRepository;
    @Autowired
    private  SwafulServices swafulServices;

    @GetMapping("swaful")
    public List<SwafullAllDto> getAllSwafulModel(){
        return swafulServices.getAllSwaful();
    }


    @PostMapping("/s1")
    public void createSwaful(@RequestBody SwafulDto swaful){
        swafulServices.addSwaful(swaful);
    }


    @GetMapping("/swaful/{id}")
    public ResponseEntity<Swaful> getSwafulById(@PathVariable long id){
        Swaful swaful = swafulRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(swaful);
    }

    @PutMapping("/edit")
    public ResponseEntity<Swaful> updatedSwaful(@RequestBody Swaful swafu){
        Swaful updatedSwaful = swafulRepository.save(swafu);
        return ResponseEntity.ok(updatedSwaful);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        swafulRepository.deleteById(id);
    }
}
