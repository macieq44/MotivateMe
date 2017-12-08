package com.gmail.macieq44.motivateme.backend.repository;

import com.gmail.macieq44.motivateme.backend.entity.Activity;
import com.gmail.macieq44.motivateme.backend.entity.ActivityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by Macieq44 on 23.11.2017.
 */
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{
    Page<Activity> findByDate(LocalDate date, Pageable pageable);
    long countByDate(LocalDate date);
    //List<Activity> findByActivityType(ActivityType activityType);
}
