package com.gmail.macieq44.motivateme.ui.calendar;

import com.gmail.macieq44.motivateme.ui.navigation.NavigationManager;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Macieq44 on 23.11.2017.
 */
@SpringComponent
@ViewScope
public class CalendarPresenter {
    private CalendarView view;
    private final NavigationManager navigationManager;

    @Autowired
    public CalendarPresenter( NavigationManager navigationManager) {
        this.navigationManager = navigationManager;
    }
    public void init(CalendarView view) {
        this.view = view;
    }

    public void dayButtonPressed(String dayOfMonth) {
        navigationManager.navigateTo(DayView.class, dayOfMonth);
    }

}
