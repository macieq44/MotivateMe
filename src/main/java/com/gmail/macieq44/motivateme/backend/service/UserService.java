package com.gmail.macieq44.motivateme.backend.service;

import com.gmail.macieq44.motivateme.backend.entity.User;
import com.gmail.macieq44.motivateme.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudService<User> {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected UserRepository getRepository() {
        return userRepository;
    }

    public User findByEmail(String email) {
        return getRepository().findByEmail(email);
    }
}
