package com.dinexpod.manik.entities;

import com.dinexpod.manik.Role;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    String login;
    String firstName;
    String lastName;
    String middleName;

    Integer age;
    String sex;
    LocalDate birthday;
    String email;
    Role userRole;
    String phoneNumber;
    String note;
    String pw;

    public User() {
    }

    public User(String login, Integer age, String sex) {
        this.login = login;
        this.age = age;
        this.sex = sex;
    }
}
