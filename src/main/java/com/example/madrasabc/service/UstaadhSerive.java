package com.example.madrasabc.service;


import com.example.madrasabc.dto.*;
import com.example.madrasabc.model.Roles;
import com.example.madrasabc.model.Swaful;
import com.example.madrasabc.model.Ustaadh;
import com.example.madrasabc.repository.RolesRepository;
import com.example.madrasabc.repository.SwafulRepository;
import com.example.madrasabc.repository.UstaadhRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class UstaadhSerive {
    private final ModelMapper mapper;
    private final UstaadhRepository ustaadhRepository;
    private final RolesRepository rolesRepository;

    public void addUstaadh(UstadhDto ustadhDto) {
        Ustaadh ustaadh = mapper.map(ustadhDto, Ustaadh.class);
        List<Roles> roles=rolesRepository.getByRolesId(ustadhDto.getRolesId());
        ustaadh.setRolesList(roles);
        ustaadhRepository.save(ustaadh);
    }

    public List<Ustaadh> getAllUstaadh(){
        List<Ustaadh> ustaadhs = ustaadhRepository.findAll();
        List<Ustaadh> ustaadhDtos= new ArrayList<>();
        for (Ustaadh ustaadh:ustaadhs) {
            ustaadhDtos.add(mapper.map(ustaadh,Ustaadh.class));
        }
        return ustaadhDtos;}

    public Ustaadh login(String email,String password){
        return  ustaadhRepository.getlogin(email,password);
    }



    public List<Setting> getsetting(){
        return ustaadhRepository.getSetting();
    }
}
