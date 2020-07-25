package com.project.music_store.controller;

import com.project.music_store.dto.InstrumentDTO;
import com.project.music_store.model.Instrument;
import com.project.music_store.repository.InstrumentRepository;
import com.project.music_store.service.InstrumentService;
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
    InstrumentService instrumentService;

    @GetMapping("/instrumentList")
    public String listProducts(Model model) {
        List<InstrumentDTO> products = instrumentService.findAllInstruments();
        model.addAttribute("products", products);
        return "instrumentListPage";
    }


    @GetMapping("/products")
    public String findProductsByKeyword(Model model, String keyword) {
        if(keyword != null) {
            model.addAttribute("products", instrumentService.findByKeyword(keyword));
        } else {
            model.addAttribute("products",instrumentService.findAllInstruments());
        }
        return "instrumentListPage";
    }

    @GetMapping("/productsDecrease")
    public String listProductsDesc(Model model, BigDecimal price) {
        model.addAttribute("products", instrumentService.sortByDecreasingPrice(price));
        return "instrumentListPage";
    }


}
