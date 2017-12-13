package com.gmail.macieq44.motivateme.ui.calendar;

import com.gmail.macieq44.motivateme.HasLogger;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import org.vaadin.spring.annotation.PrototypeScope;

/**
 * Created by Macieq44 on 10.12.2017.
 */
@SpringComponent
@PrototypeScope
public class DayComponent extends DayComponentDesign implements HasLogger {

    public DayComponent() {
        todos.setDefaultComponentAlignment(Alignment.TOP_CENTER);
    }

    public DayComponent(int dayDisplayed) {
        day.setCaption(String.valueOf(dayDisplayed));
    }

    public void setDayButtonCaption(String dayDisplayed) {
        day.setCaption(dayDisplayed);
    }

    public String getDayButtonCaption() {
        return day.getCaption();
    }

    public void addTodo(String color) {
        todos.addComponent(new TodoIndicator(color));
    }

    public Button getDayButton() {
        return day;
    }
}
