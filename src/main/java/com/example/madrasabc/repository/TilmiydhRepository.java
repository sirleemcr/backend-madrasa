package com.example.madrasabc.repository;

import com.example.madrasabc.dto.Joinexam;
import com.example.madrasabc.dto.TilmiydhDtoa;
import com.example.madrasabc.dto.TilmydhUstaadh;
import com.example.madrasabc.model.Tilmiydh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TilmiydhRepository extends JpaRepository<Tilmiydh,Long> {
   /* @Query(value = "select tilmiydh.* from tilmiydh,swaful,subject  where tilmiydh.swaful_id = swaful.id and  swaful.id=?1;",nativeQuery = true )
    List<Tilmiydh> getStudentsBySubject(int swaful_id);*/
    @Query(value = "select tilmiydh.tilmydh_id,swaful.swaful_id,subject.id from tilmiydh,swaful,subject where tilmiydh.swaful_id = swaful.swaful_id and subject.swaful_id = swaful.swaful_id and swaful.swaful_id=?1 and subject.id=?2", nativeQuery = true)
    List<Joinexam> getStudentsBySubject(Long swaful_id , Long subject_id);

    @Query(value="select *from tilmiydh where swaful_id =?1",nativeQuery = true)
    List<TilmiydhDtoa> getStudenbyclass(Long swaful_id);

    @Query(value="select *from tilmiydh where tilmydh_id =?1",nativeQuery = true)
    List<TilmiydhDtoa> getStudentbyId(Long tilmydh_id);

 @Query(value = "select tilmiydh.tilmydh_id,swaful.swaful_id,subject.id ,ustaadh.ustaadh_id from tilmiydh,swaful,subject ,ustaadh where tilmiydh.swaful_id = swaful.swaful_id and subject.swaful_id = swaful.swaful_id  and ustaadh.ustaadh_id=subject.ustaadh_id and swaful.swaful_id=?1 and subject.id=?2 and ustaadh.ustaadh_id =?3", nativeQuery = true)
 List<TilmydhUstaadh> getStudentsByUstaadh(Long swaful_id , Long subject_id,Long ustaadh_id);

}
