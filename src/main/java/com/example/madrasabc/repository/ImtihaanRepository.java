package com.example.madrasabc.repository;

import com.example.madrasabc.dto.Imtihaanbyustaadh;
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


    @Query(value = "select result.*,ustaadh.ustaadh_id,subject.id from result,ustaadh," +
            "subject where result.subject_name=subject.subject_name and subject.ustaadh_id = ustaadh.ustaadh_id and ustaadh.ustaadh_id=?1",nativeQuery = true)
    List<Result>get(Long ustaadh_id);

//    @Query(value = "select imtihaan.marks,imtihaan.tilmydh_id,imtihaan.subject_id,imtihaan.swaful_id,ustaadh.ustaadh_id,subject.subject_name from imtihaan,ustaadh,subject where" +
//            " subject.id=imtihaan.subject_id and subject.ustaadh_id = ustaadh.ustaadh_id and ustaadh.ustaadh_id=?1",nativeQuery = true)
//    List<Imtihaanbyustaadh>get(Long ustaadh_id);

}






















// create view result as select tilmiydh.tilmydh_id,subject.subject_name,imtihaan.marks,fitrah.id as fitrah_id ,fitrah.fitrah_name from tilmiydh,subject,imtihaan,fitrah where tilmiydh.tilmydh_id=imtihaan;