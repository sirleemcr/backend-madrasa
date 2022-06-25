package com.example.madrasabc.repository;


import com.example.madrasabc.dto.SubjectUtaadh;
import com.example.madrasabc.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    @Query(value="select ustaadh.first_name,ustaadh.middle_name,ustaadh.last_name,subject.id ,subject.subject_name,subject.fitrah_id ,swaful.swaful_name from ustaadh,subject ,swaful where subject.ustaadh_id=ustaadh.ustaadh_id and swaful.swaful_id=subject.swaful_id",nativeQuery = true)
    List<SubjectUtaadh>getUstaadhsubject();
}
