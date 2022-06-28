package com.example.madrasabc.repository;

import com.example.madrasabc.dto.Setting;
import com.example.madrasabc.model.Ustaadh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UstaadhRepository extends JpaRepository<Ustaadh,Long> {
    @Query(value = "select * from ustaadh where email =?1 and password =?2",nativeQuery = true)
    public Ustaadh getlogin(String email,String password);

    @Query(value = "select ustaadh.ustaadh_id, ustaadh.first_name,ustaadh.last_name,ustaadh.middle_name,roles.roles_name , " +
            "ustaadh_rol.roles_id from ustaadh,roles,ustaadh_rol where ustaadh_rol.id =ustaadh.ustaadh_id and " +
            "ustaadh_rol.roles_id=roles.roles_id",nativeQuery = true)
    public List<Setting> getSetting();
}
