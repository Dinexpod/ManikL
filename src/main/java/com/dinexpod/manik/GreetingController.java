package com.dinexpod.manik;

import com.dinexpod.manik.entities.User;
import com.dinexpod.manik.repos.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private UserRep userRep;

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("name", "Гість");
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "pages/signUp";
    }


    @GetMapping("/user")
    public String users(Map<String, Object> model) {
        Iterable<User> users = userRep.findAll();
        model.put("users", users);
        return "pages/user";
    }

    @PostMapping("/user")
    public String add(@RequestParam String login,
                      @RequestParam String sex,
                      @RequestParam Integer age,
                      Map<String, Object> model) {
        User user = new User(login, age, sex);
        userRep.save(user);

        Iterable<User> users = userRep.findAll();
        model.put("users", users);

        return "pages/user";
    }

//    @GetMapping("/user")
//    public String signUp(@RequestParam(name = "name", required = false, defaultValue = "World")
//                                 String name, Map<String, Object> model) {
//        model.put("users", name);
//        return "login";
//    }
}
