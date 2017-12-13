package com.gmail.macieq44.motivateme.ui.calendar;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.GridLayout;

/**
 * Created by Macieq44 on 23.11.2017.
 */
@SpringComponent
@UIScope
public class CalendarGrid extends GridLayout {
    public CalendarGrid() {
        setColumns(7);
        setRows(6);
    }
}
