package com.dinexpod.manik.controller;

import com.dinexpod.manik.entity.User;
import com.dinexpod.manik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {

        return "pages/registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        boolean isUserExists = !(userService.addUser(user));

        if (isUserExists) {
            model.put("message", "Такой пользователь не существует!");
            return "pages/registration";
        }

        return "redirect:login";
    }
}
