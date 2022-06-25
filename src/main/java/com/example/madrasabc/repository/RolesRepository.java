package com.example.madrasabc.repository;

import com.example.madrasabc.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RolesRepository extends JpaRepository<Roles,Long> {
    public List<Roles> getByRolesId(long rolesId);

}
