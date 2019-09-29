package com.dinexpod.manik.controller;

import com.dinexpod.manik.entity.User;
import com.dinexpod.manik.repos.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserProfileController {

    @Autowired
    private UserRep userRep;

    @GetMapping("/userProfile")
    public String userProfile(Model model) {
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        User user = userRep.findByUsername(username);
        model.addAttribute("user", user);
        return "pages/userProfile";
    }

    @PostMapping("/userProfileEdit")
    public String userProfileEdit(@RequestParam String firstName,
                                  @RequestParam String lastName,
                                  @RequestParam String middleName,
                                  @RequestParam Integer age,
                                  @RequestParam String phoneNumber,
                                  @RequestParam String email,
                                  @RequestParam("userId") User user,
                                  Model model) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMiddleName(middleName);
        user.setAge(age);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);

        userRep.save(user);

        model.addAttribute("user", user);
        return "pages/userProfile";
    }

    @GetMapping("/userProfileEdit/{user}")
    public String userSave(@PathVariable User user,
                           Model model) {
        model.addAttribute("user", user);

        return "pages/userProfileEdit";
    }
}
