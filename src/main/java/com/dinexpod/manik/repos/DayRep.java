package com.dinexpod.manik.repos;

import com.dinexpod.manik.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRep extends JpaRepository<Day, Long> {

    Day findByDateString(String dateString);
}
