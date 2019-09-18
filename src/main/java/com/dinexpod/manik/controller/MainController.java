package com.dinexpod.manik.controller;

import com.dinexpod.manik.dto.MeetDTO;
import com.dinexpod.manik.entity.Day;
import com.dinexpod.manik.entity.Meet;
import com.dinexpod.manik.entity.User;
import com.dinexpod.manik.repos.DayRep;
import com.dinexpod.manik.repos.MeetRep;
import com.dinexpod.manik.repos.UserRep;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private final UserRep userRep;
    private final DayRep dayRep;
    private final MeetRep meetRep;

    public MainController(UserRep userRep, DayRep dayRep, MeetRep meetRep) {
        this.userRep = userRep;
        this.dayRep = dayRep;
        this.meetRep = meetRep;
    }

    @GetMapping("/recorder")
    public String recorder(Map<String, Object> model) {
        Iterable<Day> days = dayRep.findAll();

        model.put("days", days);
        return "pages/recorder";
    }

    @PostMapping("/recorder")
    public String addDays(@RequestParam String masterUsername,
                          @RequestParam String date,
                          @RequestParam Integer hour,
                          @RequestParam Integer minute,
                          Map<String, Object> model) {

        User master = userRep.findByUsername(masterUsername);
        String clientUsername;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            clientUsername = ((UserDetails) principal).getUsername();
        } else {
            clientUsername = principal.toString();
        }

        User client = userRep.findByUsername(clientUsername);
        Day day = dayRep.findByDateString(date);

        if (day == null) {
            day = new Day(date);
        } else {
            day = dayRep.findByDateString(date);
        }

        Meet newMeet = new Meet(client, (hour + ":" + minute));
        List<Meet> meets = meetRep.findAllByClientAndDay(client, day).stream().map(MeetDTO::toDTO).collect(Collectors.toList());

        if (meets.contains(newMeet)) {
            newMeet = null;
            model.put("message", "на єто время уже ктото записан");
        } else {
            meetRep.save(newMeet);
            day.addOneMeet(newMeet);
            day.setMaster(master);
            day.getOccupation().set(getTransHour(hour, minute), true);
            dayRep.save(day);
        }

        if (newMeet != null) {
            newMeet.setDay(day);
            meetRep.save(newMeet);
        }

        Iterable<Day> days = dayRep.findAll();
        model.put("days", days);
        return "pages/recorder";
    }

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

    private int getTransHour(Integer hour, Integer minute) {
        switch (hour + minute) {
            case 10:
                return 0;
            case 40:
                return 1;
            case 11:
                return 2;
            case 41:
                return 3;
            case 12:
                return 4;
            case 42:
                return 5;
            case 13:
                return 6;
            case 43:
                return 7;
            case 14:
                return 8;
            case 44:
                return 9;
            case 15:
                return 10;
            case 45:
                return 11;
            case 16:
                return 12;
            case 46:
                return 13;
            case 17:
                return 14;
            case 47:
                return 15;
            case 18:
                return 16;
            case 48:
                return 17;
            case 19:
                return 18;
            case 49:
                return 19;
            case 20:
                return 20;
            case 50:
                return 21;
        }

        return 100;
    }
}
