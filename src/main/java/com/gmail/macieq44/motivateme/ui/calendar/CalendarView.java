package com.gmail.macieq44.motivateme.ui.calendar;

import com.gmail.macieq44.motivateme.HasLogger;
import com.gmail.macieq44.motivateme.ui.util.DateUtils;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.lang.annotation.Target;
import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Macieq44 on 23.11.2017.
 */
@SpringView
public class CalendarView extends CalendarViewDesign implements View, HasLogger {

    private final CalendarPresenter presenter;
    private final int ROWS = 6;
    private final int COLUMNS = 7;
    private YearMonth monthToDisplay;

    @Autowired
    public CalendarView(CalendarPresenter presenter) {
        this.presenter = presenter;
    }

    @PostConstruct
    private void init() {
        monthToDisplay = DateUtils.getInstance(new Date());
        presenter.init(this);
        gridInit();
        arrowLeft.addClickListener(e -> updateGrid(monthToDisplay = monthToDisplay.minusMonths(1)));
        arrowRight.addClickListener(e -> updateGrid(monthToDisplay = monthToDisplay.plusMonths(1)));
    }

    private List<Button> dayButtons = new ArrayList<>();
    private List<DayComponent> gridComponents = new ArrayList<>();


    private void gridInit() {
        for (int col = 0; col < COLUMNS; col++) {
            for (int row = 0; row < ROWS; row++) {
                DayComponent temp = new DayComponent();
                temp.getDayButton().addClickListener(e -> presenter.dayButtonPressed(DateUtils.getDateAsString(temp.getDayButtonCaption(), monthToDisplay)));
                gridComponents.add(temp);
                temp.addTodo("blueicon");
                calendar.addComponent(temp, col, row);
            }
        }
        DayComponent d = (DayComponent) calendar.getComponent(5, 5);
        d.addTodo("redicon");
        updateGrid(monthToDisplay);
    }

    private void updateGrid(YearMonth monthToDisplay) {
        int numberOfDays = monthToDisplay.lengthOfMonth();
        DayOfWeek firstDayOfMonth = DateUtils.getFirstDayOfMonth(monthToDisplay);
        DayComponent temp;

        int dayCounter = 1;

        for (int col = 0; col < COLUMNS; col++) {
            if (firstDayOfMonth.getValue() - 1 > col) {
                calendar.getComponent(col, 0).setVisible(false);
            } else {
                temp = (DayComponent) calendar.getComponent(col, 0);
                temp.setDayButtonCaption(String.valueOf(dayCounter++));
                temp.setVisible(true);
            }
        }

        for (int row = 1; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (dayCounter > numberOfDays) {
                    calendar.getComponent(col, row).setVisible(false);
                } else {
                    temp = (DayComponent) calendar.getComponent(col, row);
                    temp.setDayButtonCaption(String.valueOf(dayCounter++));
                    temp.setVisible(true);
                }
            }
        }
    }


}
