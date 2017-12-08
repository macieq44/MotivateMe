package com.gmail.macieq44.motivateme.ui.calendar;

import com.gmail.macieq44.motivateme.backend.entity.ActivityType;
import com.gmail.macieq44.motivateme.backend.service.ActivityTypeService;
import com.vaadin.data.provider.Query;
import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vaadin.artur.spring.dataprovider.PageableDataProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Macieq44 on 06.12.2017.
 */
@SpringComponent
public class ActivityTypeComboBoxDataProvider extends PageableDataProvider<ActivityType, String> {

    private final ActivityTypeService activityTypeService;

    @Autowired
    public ActivityTypeComboBoxDataProvider(ActivityTypeService activityTypeService) {
        this.activityTypeService = activityTypeService;
    }

    @Override
    protected Page<ActivityType> fetchFromBackEnd(Query<ActivityType, String> query, Pageable pageable) {
        return activityTypeService.findAnyMatching(query.getFilter(), pageable);
    }

    @Override
    protected List<QuerySortOrder> getDefaultSortOrders() {
        List<QuerySortOrder> sortOrders = new ArrayList<>();
        sortOrders.add(new QuerySortOrder("typeName", SortDirection.ASCENDING));
        return sortOrders;
    }

    @Override
    protected int sizeInBackEnd(Query<ActivityType, String> query) {
        return (int) activityTypeService.countAnyMatching(query.getFilter());
    }
}
