package com.project.music_store.repository;

import com.project.music_store.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Integer> {

    List<Instrument> findAll();

    @Query(
            value = "select * from instruments i where i.name like %:keyword% ",
            nativeQuery = true
    )
    List<Instrument> findByKeyword(@Param("keyword") String keyword);

    @Query(
            value = "select *  " +
                    "from music_store.instruments i where i.unit_price order by i.unit_price desc ",
            nativeQuery = true
    )
    List<Instrument> sortInstrumentsDescByPrice();


    @Query(
            value = "select *  " +
                    "from music_store.instruments i where i.unit_price order by i.unit_price ",
            nativeQuery = true
    )
    List<Instrument> sortInstrumentsAscByPrice();

    @Query(
            value = "select *  " +
                    "from music_store.instruments i where i.unit_price order by i.unit_price ",
            nativeQuery = true
    )
    List<Instrument> sortInstrumentsByName();

}


