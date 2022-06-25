package com.example.madrasabc.repository;

import com.example.madrasabc.model.Ustaadh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UstaadhRepository extends JpaRepository<Ustaadh,Long> {
    @Query(value = "select * from ustaadh where email =?1 and password =?2",nativeQuery = true)
    public Ustaadh getlogin(String email,String password);
}
