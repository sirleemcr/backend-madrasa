package com.example.madrasabc.service;

import com.example.madrasabc.dto.SwafulDto;
import com.example.madrasabc.dto.SwafullAllDto;
import com.example.madrasabc.model.Swaful;
import com.example.madrasabc.repository.SwafulRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class SwafulServices {
    private final ModelMapper mapper;
    private final SwafulRepository swafulRepository;

    public void addSwaful(SwafulDto swafulDto) {
        Swaful swaful = mapper.map(swafulDto, Swaful.class);
        swafulRepository.save(swaful);
    }

    public List<SwafullAllDto> getAllSwaful(){
        List<Swaful> swafuls = swafulRepository.findAll();
        List<SwafullAllDto> swafulDtos= new ArrayList<>();
        for (Swaful swaful:swafuls) {
            swafulDtos.add(mapper.map(swaful,SwafullAllDto.class));
        }
        return swafulDtos;}
}
