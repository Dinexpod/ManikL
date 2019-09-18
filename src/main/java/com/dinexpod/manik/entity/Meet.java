package com.dinexpod.manik.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meet implements Comparable<Meet> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String startMeet;
    private String endMeet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "day_id")
    @EqualsAndHashCode.Exclude
    private Day day;

    public Meet(User client, String startMeet, String endMeet) {
        this.client = client;
        this.startMeet = startMeet;
        this.endMeet = endMeet;
    }

    public Meet(User client, String startMeet) {
        this.client = client;
        this.startMeet = startMeet;
    }

    @Override
    public int compareTo(Meet o) {
        if (Integer.parseInt(o.startMeet.substring(0, 2)) > Integer.parseInt(this.startMeet.substring(0, 2))) {
            return 1;
        } else if (Integer.parseInt(o.startMeet.substring(0, 2)) < Integer.parseInt(this.startMeet.substring(0, 2))) {
            return -1;
        } else {
            return Integer.compare(Integer.parseInt(o.startMeet.substring(3)),
                    Integer.parseInt(this.startMeet.substring(3)));
        }
    }
}
