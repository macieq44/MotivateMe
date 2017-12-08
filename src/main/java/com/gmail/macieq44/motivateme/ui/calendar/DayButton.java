package com.gmail.macieq44.motivateme.ui.calendar;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
//import org.vaadin.spring.annotation.PrototypeScope;

/**
 * Created by Macieq44 on 23.11.2017.
 */
@SpringComponent
//@PrototypeScope
public class DayButton extends Button{
    private int dayValue;

    public DayButton() {
        setWidth(75, Unit.PIXELS);
        setHeight(75, Unit.PIXELS);
        setStyleName("borderless");
    }

    public int getDayValue() {
        return Integer.valueOf(getCaption());
    }

    public void setDayValue(int dayValue) {
        setCaption(String.valueOf(dayValue));
    }
}
