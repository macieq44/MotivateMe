package com.gmail.macieq44.motivateme.ui.calendar;

import com.gmail.macieq44.motivateme.backend.entity.Day;
import com.gmail.macieq44.motivateme.backend.service.ActivityService;
import com.gmail.macieq44.motivateme.ui.util.DateUtils;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.time.YearMonth;

/**
 * Created by Macieq44 on 29.11.2017.
 */
@SpringView
public class DayView extends DayViewDesign implements View{
    private final DayViewPresenter presenter;
    private final ActivityService activityService;

    @Autowired
    public DayView(DayViewPresenter presenter, ActivityService activityService) {
        this.presenter = presenter;
        this.activityService = activityService;
    }

    @PostConstruct
    public void init() {
        addActivity.addClickListener(e -> presenter.addPressed());
        backToCalendar.addClickListener(e -> presenter.backToCalendarPressed());
        presenter.init(this);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        presenter.enterView(event.getParameters());
    }

    public void setDay(Day dayToDisplay) {
        dateLabel.setValue(DateUtils.getDateAsString(dayToDisplay.getDate()));
        activityList.setDay(dayToDisplay);
    }
}
