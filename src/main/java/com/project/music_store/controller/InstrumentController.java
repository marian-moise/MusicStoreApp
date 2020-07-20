package com.project.music_store.controller;

import com.project.music_store.model.Instrument;
import com.project.music_store.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InstrumentController {
    @Autowired
    InstrumentRepository instrumentRepository;

    @GetMapping("/instrumentList")
    public String listProducts(Model model) {
        List<Instrument> products = instrumentRepository.findAll();
        model.addAttribute("products", products);
        return "instrumentList";
    }
}
