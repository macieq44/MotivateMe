package com.gmail.macieq44.motivateme.backend.repository;

import com.gmail.macieq44.motivateme.backend.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Macieq44 on 23.11.2017.
 */
@Repository
public interface DayRepository extends JpaRepository<Day, Long>{
    Day findByDate(LocalDate date);
}
