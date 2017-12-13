package com.gmail.macieq44.motivateme.ui.calendar;
import com.gmail.macieq44.motivateme.ui.navigation.NavigationManager;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

/**
 * Created by Macieq44 on 06.12.2017.
 */
@SpringComponent
@ViewScope
public class DayViewPresenter {
    private DayView view;
    private final NavigationManager navigationManager;

    @Autowired
    public DayViewPresenter(NavigationManager navigationManager) {
        this.navigationManager = navigationManager;
    }

    public void init(DayView view) {
        this.view = view;
    }

    public void enterView(String dayToDisplay) {

        LocalDate day = LocalDate.parse(dayToDisplay);

        refreshView(day);
    }

    private void refreshView(LocalDate dayToDisplay) {
        view.setDay(dayToDisplay);
    }

    public void addPressed() {
        navigationManager.navigateTo(ActivityEditView.class);
    }

    public void backToCalendarPressed() {
        navigationManager.navigateTo(CalendarView.class);
    }
}
