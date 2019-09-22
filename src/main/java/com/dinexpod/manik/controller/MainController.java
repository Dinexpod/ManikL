package com.dinexpod.manik.controller;

import com.dinexpod.manik.Utils;
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
import java.util.SortedSet;
import java.util.TreeSet;
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
        SortedSet<Day> setDays = new TreeSet<>(dayRep.findAll());

        model.put("days", setDays);
        return "pages/recorder";
    }

    @PostMapping("/recorder")
    public String addDays(@RequestParam String masterUsername,
                          @RequestParam String date,
                          @RequestParam Integer hour,
                          @RequestParam Integer minute,
                          @RequestParam String mainService,
                          @RequestParam String dopService,
                          Map<String, Object> model) {

        String recordStatus = "";
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
            dayRep.save(day);
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
            recordStatus = day.addOccupation(Utils.getTransHour(hour, minute), Utils.getServiceTime(mainService, dopService));
            dayRep.save(day);
        }

        if (newMeet != null) {
            newMeet.setDay(day);
            meetRep.save(newMeet);
        }

        SortedSet<Day> setDays = new TreeSet<>(dayRep.findAll());
        model.put("days", setDays);
        model.put("recordStatus", recordStatus);
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
}
