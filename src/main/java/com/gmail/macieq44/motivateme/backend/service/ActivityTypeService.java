package com.gmail.macieq44.motivateme.backend.service;

import com.gmail.macieq44.motivateme.backend.entity.ActivityType;
import com.gmail.macieq44.motivateme.backend.repository.ActivityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Macieq44 on 29.11.2017.
 */
@Service
public class ActivityTypeService extends CrudService<ActivityType> {

    private final ActivityTypeRepository activityTypeRepository;

    @Autowired
    public ActivityTypeService(ActivityTypeRepository activityTypeRepository) {
        this.activityTypeRepository = activityTypeRepository;
    }

    @Override
    protected ActivityTypeRepository getRepository() {
        return activityTypeRepository;
    }

    public Page<ActivityType> findAnyMatching(Optional<String> filter, Pageable pageable) {
        if(filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            return activityTypeRepository.findByActiveAndTypeNameLikeIgnoreCase(true, repositoryFilter, pageable);
        } else {
            return activityTypeRepository.findByActiveAndTypeNameLikeIgnoreCase(true, "%", pageable);
        }
    }

    public long countAnyMatching(Optional<String> filter) {
        return 6;
    }
}
