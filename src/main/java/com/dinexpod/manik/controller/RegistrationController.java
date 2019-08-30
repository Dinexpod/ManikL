package com.dinexpod.manik.controller;

import com.dinexpod.manik.Role;
import com.dinexpod.manik.entity.User;
import com.dinexpod.manik.repos.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRep userRep;

    @GetMapping("/registration")
    public String registration() {

        return "pages/registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User newUser = userRep.findByUsername(user.getUsername());

        if (newUser != null) {
            model.put("message", "Такий користувач вже існує!");
            return "pages/registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));

        userRep.save(user);
        return "redirect:login";
    }
}
