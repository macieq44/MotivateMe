package com.gmail.macieq44.motivateme.backend.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by Macieq44 on 23.11.2017.
 */
@Entity
public class Activity extends AbstractEntity {

    @NotNull
    private LocalDate date;
    @NotNull
    @JoinColumn(name = "activityType")
    @ManyToOne
    private ActivityType type;
    @NotNull
    @Length(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @NotNull
    @Min(1)
    @Max(10)
    private int struggle;
    @NotNull
    @Min(1)
    private int timeSpent;
    @NotNull
    private LocalTime time;

    public Activity() {}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStruggle() {
        return struggle;
    }

    public void setStruggle(int struggle) {
        this.struggle = struggle;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
