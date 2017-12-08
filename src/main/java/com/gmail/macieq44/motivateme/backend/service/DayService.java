package com.gmail.macieq44.motivateme.backend.service;

import com.gmail.macieq44.motivateme.backend.entity.Day;
import com.gmail.macieq44.motivateme.backend.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

/**
 * Created by Macieq44 on 28.11.2017.
 */
@Service
public class DayService extends CrudService<Day>{

    private final DayRepository dayRepository;

    @Autowired
    public DayService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @Override
    protected DayRepository getRepository() {
        return dayRepository;
    }

    public Page<Day> findMatching(Optional<Day> filter, Pageable pageable) {
        return null;
    }

    public long countMatching(Optional<String> filter) {
        return 0;
    }

    public Day findDay(String yyyyMMdd) {
        return dayRepository.findByDate(LocalDate.parse(yyyyMMdd));
    }
}
