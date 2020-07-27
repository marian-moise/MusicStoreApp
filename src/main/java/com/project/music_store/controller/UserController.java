package com.project.music_store.controller;

import com.project.music_store.dto.UserDTO;
import com.project.music_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "loginPage";
    }

    @PostMapping(value = "/login")
    public String postOnLoginPage(@ModelAttribute(name = "userDTO") UserDTO user, Model model) {

        String username = user.getUsername();
        String password = user.getPassword();

        if (userService.findUserByUsername(username) == null) {
            model.addAttribute("invalidCredentials", true);
            return "loginPage";
        }

        String passwordFromDb = userService.findUserByUsername(username).getPassword();

        if (password.equals(passwordFromDb)) {
            return "indexWithLogout";
        }

        model.addAttribute("invalidCredentials", true);
        return "loginPage";
    }
}
