package com.gmail.macieq44.motivateme.app;

import com.gmail.macieq44.motivateme.backend.entity.Activity;
import com.gmail.macieq44.motivateme.backend.entity.ActivityType;
import com.gmail.macieq44.motivateme.backend.repository.ActivityRepository;
import com.gmail.macieq44.motivateme.backend.repository.ActivityTypeRepository;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Macieq44 on 08.12.2017.
 */
@SpringComponent
public class DataGenerator {
    private static final String[] ACTIVITY_TYPES = new String[]{"Nauka", "Praca", "Sprzątanie", "Zakupy"};
    private static final String[] ACTIVITIES = new String[] {"Nauka MO", "Pisanie programu", "Sprzątanie kuchni", "Czytanie", "Gotowanie obiadu",
                                                            "Umycie Janka", "Zrobienie zakupów", "Nauka na egzamin z MO", "Nauka na egzamin z WP",
                                                            "Pisanie pracy Lic", "Sprzątanie łazienki"};
    private static final String[] DATES = new String[] {"2017-12-05", "2017-12-06", "2017-12-07", "2017-12-08"};

    private final Random random = new Random(2L);

    private List<LocalDate> days = new ArrayList<>();
    private List<ActivityType> activityTypes = new ArrayList<>();

    @Bean
    public CommandLineRunner loadData(ActivityRepository activityRepository, ActivityTypeRepository activityTypeRepository) {
        return args -> {
            days = createDays();
            activityTypes = createActivityTypes(activityTypeRepository);
            createActivities(activityRepository);
        };
    }

    private void createActivities(ActivityRepository activityRepository) {
        for(String activityName: ACTIVITIES) {
            Activity activity = new Activity();
            activity.setName(activityName);
            activity.setDate(days.get(random.nextInt(4)));
            activity.setStruggle(random.nextInt(6) + 1);
            activity.setTime(getRandomTime());
            activity.setTimeSpent(random.nextInt(115) + 1);
            activity.setType(activityTypes.get(random.nextInt(4)));

            activityRepository.save(activity);
        }

    }

    private List<ActivityType> createActivityTypes(ActivityTypeRepository activityTypeRepository) {
        List<ActivityType> types = new ArrayList<>();
        for(String type: ACTIVITY_TYPES) {
            ActivityType activityType = new ActivityType();
            activityType.setActive(true);
            activityType.setPriority(3);
            activityType.setTypeName(type);
            types.add(activityType);
            activityTypeRepository.save(activityType);
        }

        return types;
    }

    private List<LocalDate> createDays() {
        List<LocalDate> days = new ArrayList<>();
        for(String date: DATES) {
            LocalDate day = LocalDate.parse(date);
            days.add(day);
        }

        return days;
    }

    private LocalTime getRandomTime() {
        int hours = random.nextInt(24);
        int minutes = random.nextInt(60);
        int seconds = random.nextInt(60);

        String hh = hours < 10 ? "0" + String.valueOf(hours) : String.valueOf(hours);
        String mm = minutes < 10 ? "0" + String.valueOf(minutes) : String.valueOf(minutes);
        String ss = seconds < 10 ? "0" + String.valueOf(seconds) : String .valueOf(seconds);

        return LocalTime.parse(hh + ":" + mm + ":" +ss);
    }


}
