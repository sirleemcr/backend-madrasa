package com.example.madrasabc.service;


import com.example.madrasabc.dto.RolesDto;
import com.example.madrasabc.dto.RolesDtoAll;
import com.example.madrasabc.model.Roles;
import com.example.madrasabc.repository.RolesRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class RolesService {
    private  final ModelMapper mapper;
    private final RolesRepository rolesRepository;

    public  void  addrole(RolesDto rolesDto){
        Roles roles= mapper.map(rolesDto,Roles.class);
        rolesRepository.save(roles);

    }

    public List <RolesDtoAll> getRoles(){
        List<Roles >roles=rolesRepository.findAll();
        List<RolesDtoAll>rolesDtoAlls=new ArrayList<>();
        for (Roles roles1: roles){
            rolesDtoAlls.add(mapper.map(roles1, RolesDtoAll.class));
        }
        return rolesDtoAlls;
    }

    public Roles getById(Long rolesId){
        return rolesRepository.findById(rolesId).get();
    }
}
