package com.gmail.macieq44.motivateme.ui.calendar;
import com.gmail.macieq44.motivateme.backend.service.ActivityService;
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
    private LocalDate date;
    private final NavigationManager navigationManager;

    @Autowired
    private ActivityService activityService;

    @Autowired
    public DayViewPresenter(NavigationManager navigationManager) {
        this.navigationManager = navigationManager;
    }

    public void init(DayView view) {
        this.view = view;
    }

    public void enterView(String dayToDisplay) {

        date = LocalDate.parse(dayToDisplay);

        refreshView(date);
    }

    private void refreshView(LocalDate dayToDisplay) {
        view.setDay(dayToDisplay);
    }

    public void addPressed() {
        if (view.checkBeforeMaking()) {
            return;
        }
        activityService.save(view.makeNewActivity(date));
        view.refreshActivityList();
    }

    public void backToCalendarPressed() {
        navigationManager.navigateTo(CalendarView.class);
    }
}
