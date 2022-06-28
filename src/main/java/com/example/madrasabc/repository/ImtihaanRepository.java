package com.example.madrasabc.repository;

import com.example.madrasabc.dto.Result;
import com.example.madrasabc.model.Imtihaan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ImtihaanRepository extends JpaRepository<Imtihaan,Long> {
    @Query(value = "select * from result where tilmydh_id=?1 ",nativeQuery = true)
    List<Result>getSubjectbyMarks(Long tilmydh_id);

     @Query(value="select * from result where tilmydh_id=?1 and fitrah_id=?2",nativeQuery = true)
    List<Result>geStudentsMarks(Long tilmydh_id ,Long fitrah_id);
     @Query(value = "select * from result",nativeQuery = true)
    List<Result> getRes();

    @Query(value="select * from imtihaan where tilmydh_id=?1 and subject_id=?2 and swaful_id=?3",nativeQuery = true)
    Optional<Imtihaan> geStudent(Long tilmydh_id , Long subject_id,Long swaful_id);

}






















// create view result as select tilmiydh.tilmydh_id,subject.subject_name,imtihaan.marks,fitrah.id as fitrah_id ,fitrah.fitrah_name from tilmiydh,subject,imtihaan,fitrah where tilmiydh.tilmydh_id=imtihaan;