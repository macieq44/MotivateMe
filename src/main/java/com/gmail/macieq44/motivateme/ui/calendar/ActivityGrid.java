package com.gmail.macieq44.motivateme.ui.calendar;

import com.gmail.macieq44.motivateme.backend.entity.Activity;
import com.gmail.macieq44.motivateme.backend.entity.ActivityType;
import com.gmail.macieq44.motivateme.backend.entity.Day;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.HtmlUtils;
import org.vaadin.spring.annotation.PrototypeScope;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

/**
 * Created by Macieq44 on 06.12.2017.
 */
@SpringComponent
@PrototypeScope
public class ActivityGrid extends Grid<Activity> {

    @Autowired
    private ActivityDataProvider dataProvider;


    public ActivityGrid() {
        addStyleName("activity-grid");
        removeHeaderRow(0);

        // Time column
        Column<Activity, String> timeColumn = addColumn(activity -> String.valueOf(activity.getTime()));
        timeColumn.setSortProperty("time");

        // Activity name and type column
        Column<Activity, String> infoColumn = addColumn(activity -> {
            ActivityType activityType = activity.getType();
            return twoRowCell(activity.getName(), activityType.getTypeName());
        }, new HtmlRenderer()).setExpandRatio(1).setMinimumWidthFromContent(false);
        infoColumn.setStyleGenerator(activity -> "summary");

        // Value column
        Column<Activity, String> valueColumn = addColumn(activity -> {
            ActivityType activityType = activity.getType();
            return String.valueOf(activityType.getPriority() * activity.getStruggle() * (activity.getTimeSpent() * 0.1));
        });
        valueColumn.setStyleGenerator(activity -> "value");

    }

    @PostConstruct
    public void init() {
        setDataProvider(dataProvider);
    }

    public void setDay(LocalDate day) {
        dataProvider.setDay(day);
    }

    private static String twoRowCell(String header, String content) {
        return "<div class=\"header\">" + HtmlUtils.htmlEscape(header) + "</div><div class=\"content\">"
                + HtmlUtils.htmlEscape(content) + "</div>";
    }
}
