package com.project.music_store.service;

import com.project.music_store.dto.InstrumentDTO;
import com.project.music_store.model.Instrument;
import com.project.music_store.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class InstrumentService {

    @Autowired
    InstrumentRepository instrumentRepository;

    public List<InstrumentDTO> sortByDecreasingPrice(BigDecimal price) {
        List<Instrument> instruments =
                instrumentRepository.findInstrumentByUnitPriceOrderByUnitPriceDesc(price);
        return convertToDTOs(instruments);
    }

    public List<InstrumentDTO> findByKeyword(String keyword) {
        return convertToDTOs(instrumentRepository.findByKeyword(keyword));
    }





    private List<InstrumentDTO> convertToDTOs(List<Instrument> instruments) {
        List<InstrumentDTO> instrDTO = new ArrayList<>();

        for (Instrument i : instruments) {
            instrDTO.add(
                    new InstrumentDTO(i.getName(), i.getUnitPrice(),
                            i.getConcurrency(), i.getImageUrl()));
        }
        return  instrDTO;
    }
}
