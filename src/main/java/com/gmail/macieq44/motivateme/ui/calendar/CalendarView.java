package com.gmail.macieq44.motivateme.ui.calendar;

import com.gmail.macieq44.motivateme.ui.util.DateUtils;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Macieq44 on 23.11.2017.
 */
@SpringView
public class CalendarView extends CalendarViewDesign implements View {
    private final CalendarPresenter presenter;
    private final int ROWS = 6;
    private final int COLUMNS = 7;
    private YearMonth monthToDisplay;

    @Autowired
    public CalendarView(CalendarPresenter presenter) {
        this.presenter = presenter;
        initComponents();
    }

    @PostConstruct
    public void init() {
        Date date = new Date();

        monthToDisplay = DateUtils.getInstance(new Date());
        presenter.init(this);
        gridInit();
        arrowLeftButton.addClickListener(e -> updateGrid(monthToDisplay = monthToDisplay.minusMonths(1)));
        arrowRightButton.addClickListener(e -> updateGrid(monthToDisplay = monthToDisplay.plusMonths(1)));
    }

    public void initComponents() {
    }


    private List<Button> dayButtons = new ArrayList<>();



    public void gridInit() {

        for(int col = 0; col < COLUMNS; col++) {
            for (int row = 0; row < ROWS; row++) {
                Button temp = new Button();
                temp.addClickListener(e -> presenter.dayButtonPressed(DateUtils.getDateAsString(temp.getCaption(), monthToDisplay)));
                dayButtons.add(temp);
                calendar.addComponent(temp, col, row);
            }
        }

        updateGrid(monthToDisplay);

    }

    private void updateGrid(YearMonth monthToDisplay) {
        int numberOfDays = monthToDisplay.lengthOfMonth();
        DayOfWeek firstDayOfMonth = DateUtils.getFirstDayOfMonth(monthToDisplay);
        Button temp;

        int dayCounter = 1;

        for(int col = 0; col < COLUMNS; col++) {
            if(firstDayOfMonth.getValue() - 1 > col) {
                calendar.getComponent(col, 0).setVisible(false);
            } else {
                temp = (Button) calendar.getComponent(col, 0);
                temp.setCaption(String.valueOf(dayCounter++));
                temp.setVisible(true);
            }
        }

        for (int row = 1; row < ROWS; row++) {
            for(int col = 0; col < COLUMNS; col++) {
                if (dayCounter > numberOfDays){
                    calendar.getComponent(col, row).setVisible(false);
                } else {
                    temp = (Button) calendar.getComponent(col, row);
                    temp.setCaption(String.valueOf(dayCounter++));
                    temp.setVisible(true);
                }
            }
        }
    }



}
