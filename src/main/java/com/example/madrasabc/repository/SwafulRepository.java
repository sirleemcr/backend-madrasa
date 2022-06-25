package com.example.madrasabc.repository;

import com.example.madrasabc.model.Swaful;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SwafulRepository extends JpaRepository<Swaful,Long> {
}
