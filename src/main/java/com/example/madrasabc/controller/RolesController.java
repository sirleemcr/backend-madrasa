package com.example.madrasabc.controller;



import com.example.madrasabc.dto.RolesDto;
import com.example.madrasabc.dto.RolesDtoAll;

import com.example.madrasabc.model.Roles;
import com.example.madrasabc.model.Subject;
import com.example.madrasabc.repository.RolesRepository;
import com.example.madrasabc.service.RolesService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("r")
@Data
public class RolesController {

    @Autowired
    private final RolesRepository rolesRepository;

    @Autowired
    private RolesService rolesService;

    @PostMapping("/r1")
    public void createRoles(@RequestBody RolesDto rolesDto){
        rolesService.addrole(rolesDto);
    }

    @GetMapping("/r2")
    public List<RolesDtoAll> getRoles(){
       return rolesService.getRoles();
    }

    @GetMapping("/role/{id}")
    public Roles getByRoleId(Long role){
        return rolesService.getById(role);
    }
}
