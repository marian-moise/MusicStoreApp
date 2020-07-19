package com.project.music_store.controller;


import com.project.music_store.dto.UserDTO;
import com.project.music_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class HomeController {


    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String postOnLoginPage(@ModelAttribute(name = "userDTO") UserDTO user, Model model) {


        String username = user.getUsername();
        String password = user.getPassword();
        UserDTO userDTO = new UserDTO(username,password);
        System.out.println(userDTO);
        String passwordFromDb = userService.findUserByUsername(username).getPassword();


        if (password.equals(passwordFromDb)) {
            return "indexWithLogout";
        }

        model.addAttribute("invalidCredentials", true);
        return "login";
    }
}
