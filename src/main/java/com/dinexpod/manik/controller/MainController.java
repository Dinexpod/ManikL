package com.dinexpod.manik.controller;

import com.dinexpod.manik.entity.User;
import com.dinexpod.manik.repos.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserRep userRep;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        model.put("name", "Гість");
        return "main";
    }

    @GetMapping("/user")
    public String users(Map<String, Object> model) {
        Iterable<User> users = userRep.findAll();
        model.put("users", users);
        return "pages/user";
    }

    @PostMapping("/user")
    public String add(@RequestParam String username,
                      @RequestParam String sex,
                      @RequestParam Integer age,
                      Map<String, Object> model) {
        User user = new User(username, age, sex);
        userRep.save(user);

        Iterable<User> users = userRep.findAll();
        model.put("users", users);

        return "pages/user";
    }
}
