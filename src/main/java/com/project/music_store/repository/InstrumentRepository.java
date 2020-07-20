package com.project.music_store.repository;

import com.project.music_store.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Integer> {

    List<Instrument> findAll();
}
