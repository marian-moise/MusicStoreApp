package com.project.music_store.controller;

import com.project.music_store.dto.InstrumentDTO;
import com.project.music_store.model.Instrument;
import com.project.music_store.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
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


    @GetMapping("/products")
    public String findProductsByKeyword(Model model, String keyword) {
        if(keyword != null) {
            model.addAttribute("products", instrumentRepository.findByKeyword(keyword));
        } else {
            model.addAttribute("products",instrumentRepository.findAll());
        }
        return "instrumentList";
    }




    @PostMapping(value = "/instrumentList")
    public String listProductsDesc(@ModelAttribute(name = "instrumentDTO") InstrumentDTO instrumentDTO,
                                   Model model) {

        BigDecimal price = instrumentDTO.getUnitPrice();
        List<Instrument> products = instrumentRepository.findInstrumentByUnitPriceOrderByUnitPriceDesc(price);
        model.addAttribute("products", products);
        return "instrumentList";
    }


}
