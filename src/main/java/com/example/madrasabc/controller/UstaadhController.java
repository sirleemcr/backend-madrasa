package com.example.madrasabc.controller;


import com.example.madrasabc.dto.Setting;
import com.example.madrasabc.dto.UstaadhAllDto;
import com.example.madrasabc.dto.UstadhDto;

import com.example.madrasabc.model.Ustaadh;
import com.example.madrasabc.repository.UstaadhRepository;

import com.example.madrasabc.service.UstaadhSerive;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@CrossOrigin
@RestController
@RequestMapping("u")
@Data

public class UstaadhController {

    @Autowired
    private UstaadhRepository ustaadhRepository;
    @Autowired
    private UstaadhSerive ustaadhSerive;

    @GetMapping("ustaadh")
    public List<Ustaadh> getAllUstaadhModel() {
        return ustaadhSerive.getAllUstaadh();
    }


    @PostMapping("/u1")
    public void createUstaadh(@RequestBody UstadhDto ustaadh) {
        ustaadhSerive.addUstaadh(ustaadh);
    }


    @GetMapping("/ustaadh/{id}")
    public ResponseEntity<Ustaadh> getUstaadhById(@PathVariable long id) {
        Ustaadh ustaadh = ustaadhRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(ustaadh);
    }

    @PutMapping("/edit")
    public ResponseEntity<Ustaadh> updatedUstaadh(@RequestBody Ustaadh ustaad) {
        Ustaadh updatedUstaadh = ustaadhRepository.save(ustaad);
        return ResponseEntity.ok(updatedUstaadh);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        ustaadhRepository.deleteById(id);
    }

    @GetMapping("/email/{email}/password/{password}")
    public Ustaadh getlogins(@PathVariable("email") String email, @PathVariable("password") String password) {
        return ustaadhSerive.login(email, password);
    }

    @GetMapping("/setting")
    public  List<Setting> getallsetting(){
        return ustaadhSerive.getsetting();
    }
}