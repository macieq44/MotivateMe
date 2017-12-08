package com.gmail.macieq44.motivateme.ui.calendar;

import com.gmail.macieq44.motivateme.backend.entity.Day;
import com.gmail.macieq44.motivateme.backend.service.ActivityService;
import com.gmail.macieq44.motivateme.backend.service.ActivityTypeService;
import com.gmail.macieq44.motivateme.backend.service.DayService;
import com.gmail.macieq44.motivateme.ui.navigation.NavigationManager;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.springframework.beans.factory.annotation.Autowired;
//import org.vaadin.spring.events.EventBus.ViewEventBus;
//import org.vaadin.spring.events.annotation.EventBusListenerMethod;

import javax.annotation.PreDestroy;

/**
 * Created by Macieq44 on 23.11.2017.
 */
@SpringComponent
@ViewScope
public class CalendarPresenter {
    private CalendarView view;

    //private final ViewEventBus viewEventBus;
    private final NavigationManager navigationManager;
    private final DayService dayService;
    private final ActivityService activityService;
    private final ActivityTypeService activityTypeService;
    

    @Autowired
    public CalendarPresenter( NavigationManager navigationManager, DayService dayService, ActivityService activityService, ActivityTypeService activityTypeService) {
        //this.viewEventBus = viewEventBus;
        this.navigationManager = navigationManager;
        this.dayService = dayService;
        this.activityService = activityService;
        this.activityTypeService = activityTypeService;

        //viewEventBus.subscribe(this);
    }

    public void init(CalendarView view) {
        this.view = view;
    }

    //@PreDestroy
    //public void destroy() {
    //    viewEventBus.unsubscribe(this);
    //}

    public void evnterView(Long id) {
        if (id == null) {
            // TODO
            return;
        } else {

        }
    }

    public void dayButtonPressed(String dayOfMonth) {
        navigationManager.navigateTo(DayView.class, dayOfMonth);
    }

    public void enterView(String dayToDisplay) {
        Day day;
        if (dayToDisplay == null) {
            //TODO
            day = new Day();
        } else {
            day = dayService.findDay(dayToDisplay);
        }

        refreshView(day);
    }

    private void refreshView(Day day) {

    }

}
