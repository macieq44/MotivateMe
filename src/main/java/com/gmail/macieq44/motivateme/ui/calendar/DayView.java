package com.gmail.macieq44.motivateme.ui.calendar;

import com.gmail.macieq44.motivateme.backend.entity.Activity;
import com.gmail.macieq44.motivateme.backend.entity.Day;
import com.gmail.macieq44.motivateme.backend.service.ActivityService;
import com.gmail.macieq44.motivateme.ui.util.DateUtils;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Macieq44 on 29.11.2017.
 */
@SpringView
public class DayView extends DayViewDesign implements View{
    private final DayViewPresenter presenter;



    @Autowired
    public DayView(DayViewPresenter presenter) {
        this.presenter = presenter;
    }

    @PostConstruct
    public void init() {
        addActivity.addClickListener(e -> presenter.addPressed());
        backToCalendar.addClickListener(e -> presenter.backToCalendarPressed());
        presenter.init(this);
        List<Integer> struggleOptions = new ArrayList();
        struggleOptions.add(1);
        struggleOptions.add(2);
        struggleOptions.add(3);
        struggleOptions.add(4);
        struggleOptions.add(5);
        struggle.setItems(struggleOptions);
        struggle.setEmptySelectionAllowed(false);
        struggle.setSelectedItem(1);

    }

    @Override
    public void enter(ViewChangeEvent event) {
        presenter.enterView(event.getParameters());
    }

    public void setDay(LocalDate dayToDisplay) {
        date.setValue(DateUtils.getDateAsString(dayToDisplay));
        activityList.setDay(dayToDisplay);
    }

    public Activity makeNewActivity(LocalDate date) {
        Activity temp = new Activity();
        temp.setDate(date);
        temp.setName(name.getValue());
        temp.setTimeSpent(Integer.valueOf(duration.getValue()));
        temp.setStruggle(struggle.getValue());
        temp.setTime(LocalTime.now());
        temp.setType(type.getValue());
        return temp;
    }

    public void refreshActivityList() {
        activityList.refresh();
    }

    public boolean checkBeforeMaking() {
        if (name.isEmpty() || duration.isEmpty() || type.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
