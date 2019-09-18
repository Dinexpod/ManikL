package com.dinexpod.manik.repos;

import com.dinexpod.manik.entity.Meet;
import com.dinexpod.manik.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetRep extends JpaRepository<Meet, Long> {

    List<Meet> findAllByClient(User client);
}
