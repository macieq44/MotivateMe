package com.gmail.macieq44.motivateme.backend.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Macieq44 on 23.11.2017.
 */
@Entity
public class ActivityType extends AbstractEntity{

    @NotNull
    @Length(min = 1, max = 30)
    private String typeName;

    @NotNull
    @Min(1)
    @Max(10)
    private int priority;

    @NotNull
    private boolean active;

    public ActivityType() {}

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



}
