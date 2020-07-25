package com.project.music_store.repository;

import ch.qos.logback.core.boolex.EvaluationException;
import com.project.music_store.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Integer> {

    List<Instrument> findAll();
    List<Instrument> findInstrumentByUnitPriceOrderByUnitPriceDesc(BigDecimal price);


    @Query(
            value = "select * from instruments i where i.name like %:keyword% ",
            nativeQuery = true
    )
    List<Instrument> findByKeyword(@Param("keyword") String keyword);
}
