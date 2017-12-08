package com.gmail.macieq44.motivateme.backend.repository;

import com.gmail.macieq44.motivateme.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Macieq44 on 27.11.2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);

}
