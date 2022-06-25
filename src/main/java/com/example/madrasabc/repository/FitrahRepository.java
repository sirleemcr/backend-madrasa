package com.example.madrasabc.repository;

import com.example.madrasabc.model.Fitrah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FitrahRepository extends JpaRepository<Fitrah,Long> {
}
