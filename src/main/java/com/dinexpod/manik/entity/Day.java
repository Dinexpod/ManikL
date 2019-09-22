package com.dinexpod.manik.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Day implements Comparable<Day> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dateString;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_id")
    private User master;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Meet> meets = new HashSet<>();

    @ElementCollection(targetClass = Boolean.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "day_occupation", joinColumns = @JoinColumn(name = "day_id"))
    @OrderColumn
    private List<Boolean> occupation = new ArrayList<>(Collections.nCopies(22, false));

    public Day(String dateString) {
        this.dateString = dateString;
    }

    public void addOneMeet(Meet meet) {
        this.meets.add(meet);
    }

    @Override
    public int compareTo(Day o) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate thisDateString = LocalDate.parse(this.dateString, formatter);
        LocalDate dateString = LocalDate.parse(o.dateString, formatter);

        if (dateString.isAfter(thisDateString)) {
            return -1;
        } else if (dateString.isBefore(thisDateString)) {
            return 1;
        } else {
            return 0;
        }
    }
}