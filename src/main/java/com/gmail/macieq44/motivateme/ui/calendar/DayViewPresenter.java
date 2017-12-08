package com.gmail.macieq44.motivateme.ui.calendar;

import com.gmail.macieq44.motivateme.backend.entity.Day;
import com.gmail.macieq44.motivateme.backend.service.ActivityService;
import com.gmail.macieq44.motivateme.backend.service.ActivityTypeService;
import com.gmail.macieq44.motivateme.backend.service.DayService;
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
    private final DayService dayService;
    private final ActivityService activityService;
    private final ActivityTypeService activityTypeService;

    @Autowired
    public DayViewPresenter(NavigationManager navigationManager, DayService dayService, ActivityService activityService, ActivityTypeService activityTypeService) {
        this.navigationManager = navigationManager;
        this.dayService = dayService;
        this.activityService = activityService;
        this.activityTypeService = activityTypeService;
    }

    public void init(DayView view) {
        this.view = view;
    }

    public void enterView(String dayToDisplay) {
        Day day;
        if (dayToDisplay == null) {
            //TODO
            day = new Day();
        } else {
            day = dayService.findDay(dayToDisplay);
        }

        if (day == null) {
            day = new Day();
            day.setDate(LocalDate.parse(dayToDisplay));
            dayService.save(day);
        }

        refreshView(day);
    }

    private void refreshView(Day dayToDisplay) {
        view.setDay(dayToDisplay);
    }

    public void addPressed() {
        navigationManager.navigateTo(ActivityEditView.class);
    }

    public void backToCalendarPressed() {
        navigationManager.navigateTo(CalendarView.class);
    }
}
