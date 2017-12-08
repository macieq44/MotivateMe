package com.gmail.macieq44.motivateme.backend.service;

import com.gmail.macieq44.motivateme.backend.entity.Activity;
import com.gmail.macieq44.motivateme.backend.repository.ActivityRepository;
import com.gmail.macieq44.motivateme.ui.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

/**
 * Created by Macieq44 on 29.11.2017.
 */
@Service
public class ActivityService extends CrudService<Activity> {

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    protected ActivityRepository getRepository() {
        return activityRepository;
    }

    public Page<Activity> findMatching(Optional<LocalDate> filter, Pageable pageable) {
        if (filter.isPresent()) {
            return activityRepository.findByDate(filter.get(), pageable);
        } else {
            return activityRepository.findByDate(LocalDate.parse("2017-12-08"), pageable);
        }


    }

    public long countMatching(Optional<LocalDate> filter) {
        if (filter.isPresent()) {
            return activityRepository.countByDate(filter.get());
        } else {
            return 0;
        }
    }
}
