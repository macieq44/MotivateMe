package com.gmail.macieq44.motivateme.backend.repository;

import com.gmail.macieq44.motivateme.backend.entity.ActivityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Macieq44 on 23.11.2017.
 */
@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long>{
    Page<ActivityType> findByActive(boolean active, Pageable pageable);
    Page<ActivityType> findByTypeNameLikeIgnoreCase(String filter, Pageable pageable);
    Page<ActivityType> findByActiveAndTypeNameLikeIgnoreCase(boolean active, String filter, Pageable pageable);
    //List<ActivityType> findByActive(boolean active);

    //int countByNameLikeIgnoreCase(String nameFilter);
}
