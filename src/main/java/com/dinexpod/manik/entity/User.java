package com.dinexpod.manik.entity;

import com.dinexpod.manik.Role;
import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private String middleName;

    private Integer age;
    private String sex;
    private LocalDate birthday;
    private String email;
    private String phoneNumber;
    private String note;
    private String password;
    private Boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User() {

    }

    public User(String username, Integer age, String sex) {
        this.username = username;
        this.age = age;
        this.sex = sex;
    }
}
