package com.project.music_store.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {


    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }


}
