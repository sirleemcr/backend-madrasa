package com.example.madrasabc.service;



import com.example.madrasabc.dto.*;

import com.example.madrasabc.model.Tilmiydh;
import com.example.madrasabc.repository.TilmiydhRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class TilmiydhService {

    private final ModelMapper mapper;
    private final TilmiydhRepository tilmiydhRepository;

    public void addTilmiydh(TilmiydhDto tilmiydhDto) {
        Tilmiydh tilmiydh = mapper.map(tilmiydhDto, Tilmiydh.class);
        tilmiydhRepository.save(tilmiydh);
    }

    public List<TilmiydhAllDto> getAllTilmiydh(){
        List<Tilmiydh> tilmiydhs = tilmiydhRepository.findAll();
        List<TilmiydhAllDto> tilmiydhDtos= new ArrayList<>();
        for (Tilmiydh tilmiydh:tilmiydhs) {
            tilmiydhDtos.add(mapper.map(tilmiydh,TilmiydhAllDto.class));
        }
        return tilmiydhDtos;}

    public List<Joinexam> getAllTilmiydhBysub(Long swaful_id, Long subject_id){
        return tilmiydhRepository.getStudentsBySubject(swaful_id,subject_id);
    }

    public List<TilmiydhDtoa> getTilmiydhByclass(Long swaful_id){
        return tilmiydhRepository.getStudenbyclass(swaful_id);
    }

    public List<TilmiydhDtoa> getTilmiydhById(Long tilmydh_id){
        return tilmiydhRepository.getStudentbyId(tilmydh_id);
    }

    public List<TilmydhUstaadh> getStudentByUstaadh(Long swaful_id,Long subject_id ,Long ustaadh_id){
        return  tilmiydhRepository.getStudentsByUstaadh(swaful_id, subject_id, ustaadh_id);
    }

}
