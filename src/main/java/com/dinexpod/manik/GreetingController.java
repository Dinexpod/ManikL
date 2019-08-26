package com.dinexpod.manik;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class GreetingController {

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


//    @GetMapping("/signUp")
//    public String signUp(@RequestParam(name = "name", required = false, defaultValue = "World")
//                                 String name, Map<String, Object> model) {
//        model.put("name", name);
//        return "login";
//    }
}