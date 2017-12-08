package com.gmail.macieq44.motivateme.backend.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Macieq44 on 23.11.2017.
 */
@Entity
public class Day extends AbstractEntity{

    @NotNull
    private LocalDate date;

    public Day() {}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
