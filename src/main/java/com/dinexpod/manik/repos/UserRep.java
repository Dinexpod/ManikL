package com.dinexpod.manik.repos;

import com.dinexpod.manik.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRep extends CrudRepository<User, Long> {

}
