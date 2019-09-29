package com.dinexpod.manik.controller;

import com.dinexpod.manik.Utils;
import com.dinexpod.manik.dto.MeetDTO;
import com.dinexpod.manik.entity.Day;
import com.dinexpod.manik.entity.Meet;
import com.dinexpod.manik.entity.User;
import com.dinexpod.manik.repos.DayRep;
import com.dinexpod.manik.repos.MeetRep;
import com.dinexpod.manik.repos.UserRep;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Controller
public class MeetRecordController {

    private final UserRep userRep;
    private final DayRep dayRep;
    private final MeetRep meetRep;

    public MeetRecordController(UserRep userRep, DayRep dayRep, MeetRep meetRep) {
        this.userRep = userRep;
        this.dayRep = dayRep;
        this.meetRep = meetRep;
    }

    @GetMapping("/clientMeetsList")
    public String clientMeetsList(Map<String, Object> model) {
        String clientUsername;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            clientUsername = ((UserDetails) principal).getUsername();
        } else {
            clientUsername = principal.toString();
        }

        SortedSet<Meet> meets = new TreeSet<>(meetRep.findAllByClient(userRep.findByUsername(clientUsername)));

        model.put("meets", meets);
        return "pages/clientMeetsList";
    }

    @PostMapping("/clientMeetsList")
    public String clientDayRecordList(Map<String, Object> model) {
        SortedSet<Meet> meets = new TreeSet<>(meetRep.findAll());

        model.put("meets", meets);
        return "pages/clientMeetsList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/masterMeetsList")
    public String masterMeetsList(Map<String, Object> model) {
        Day day = dayRep.findByDateString(LocalDate.now().toString());

        if (day == null) {
            day = dayRep.save(new Day(LocalDate.now().toString()));
        }

        SortedSet<Meet> meets = new TreeSet<>(meetRep.findAllByDay(day));

        model.put("day", day);
        model.put("meets", meets);
        return "pages/masterMeetsList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/masterMeetsList")
    public String masterDayRecordList(@RequestParam String date,
                                       Map<String, Object> model) {
        Day day = dayRep.findByDateString(date);

        if (day == null) {
            day = dayRep.save(new Day(date));
        }

        SortedSet<Meet> meets = new TreeSet<>(meetRep.findAllByDay(day));

        model.put("meets", meets);
        model.put("day", day);
        return "pages/masterMeetsList";
    }

    @GetMapping("/recorder")
    public String recorder(Map<String, Object> model) {
        SortedSet<Day> setDays = new TreeSet<>(dayRep.findAll());

        model.put("days", setDays);
        return "pages/recorder";
    }

    @PostMapping("/recorder")
    public String addDays(@RequestParam String masterUsername,
                          @RequestParam String yearNum,
                          @RequestParam String monthNum,
                          @RequestParam String dayNum,
                          @RequestParam Integer hour,
                          @RequestParam Integer minute,
                          @RequestParam String mainService,
                          @RequestParam String dopService,
                          Map<String, Object> model) {

        String meetEndTime = "";
        User master = userRep.findByUsername(masterUsername);
        String clientUsername;
        String date = yearNum + "-" + monthNum + "-" + dayNum;

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
            meetEndTime = day.addOccupationAndReturnEndTime(Utils.getTransHour(hour, minute),
                    Utils.getServiceTime(mainService, dopService));
            newMeet.setEndMeet(meetEndTime);
            newMeet.setServicesList(Utils.parseServicesList(mainService, dopService));
            meetRep.save(newMeet);
            day.addOneMeet(newMeet);
            day.setMaster(master);
            dayRep.save(day);
        }

        if (newMeet != null) {
            newMeet.setDay(day);
            meetRep.save(newMeet);
        }

        if (meetEndTime.length() > 1) {
            model.put("recordStatus", "запись успешна!");
        } else {
            model.put("recordStatus", "это время занято");
        }

        SortedSet<Day> setDays = new TreeSet<>(dayRep.findAll());
        model.put("days", setDays);
        return "pages/recorder";
    }
}
