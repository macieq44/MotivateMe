package com.gmail.macieq44.motivateme.ui.calendar;


import com.gmail.macieq44.motivateme.backend.entity.Activity;
import com.gmail.macieq44.motivateme.backend.entity.Day;
import com.gmail.macieq44.motivateme.backend.service.ActivityService;
import com.vaadin.data.provider.Query;
import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;
import org.vaadin.artur.spring.dataprovider.PageableDataProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Macieq44 on 06.12.2017.
 */
@SpringComponent
public class ActivityDataProvider extends FilterablePageableDataProvider<Activity, Object> {

    private final ActivityService activityService;
    private LocalDate filterDate;

    @Autowired
    public ActivityDataProvider(ActivityService activityService) {
        this.activityService = activityService;
    }


    @Override
    protected Page<Activity> fetchFromBackEnd(Query<Activity, Object> query, Pageable pageable) {
        return activityService.findMatching(getOptionalFilterDate(), pageable);
    }

    private Optional<LocalDate> getOptionalFilterDate() {
        if (filterDate == null) {
            return Optional.empty();
        } else {
            return Optional.of(filterDate);
        }
    }

    @Override
    protected List<QuerySortOrder> getDefaultSortOrders() {
        List<QuerySortOrder> sortOrders = new ArrayList<>();
        sortOrders.add(new QuerySortOrder("name", SortDirection.ASCENDING));
        return sortOrders;
    }

    @Override
    protected int sizeInBackEnd(Query<Activity, Object> query) {
        return (int) activityService.countMatching(getOptionalFilterDate());
    }

    public void setDay(Day day) {
        filterDate = day.getDate();
        this.refreshAll();
    }
}
