package com.gmail.macieq44.motivateme.backend.service;

import com.gmail.macieq44.motivateme.backend.Role;
import com.gmail.macieq44.motivateme.backend.UserAlreadyExistException;
import com.gmail.macieq44.motivateme.backend.entity.User;
import com.gmail.macieq44.motivateme.backend.repository.UserRepository;
import com.gmail.macieq44.motivateme.backend.web.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudService<User> {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected UserRepository getRepository() {
        return userRepository;
    }

    public User findByEmail(String email) {
        return getRepository().findByEmail(email);
    }

    public User registerNewUserAccount(final UserDto account) {
        if (emailExist(account.getEmail())){
            throw new UserAlreadyExistException("User with given email already exists.");
        }
        User user = new User();
        user.setName(account.getName());
        user.setEmail(account.getEmail());
        user.setPassword(passwordEncoder.encode(account.getPassword()));
        user.setRole(Role.USER);
        return userRepository.save(user);

    }

    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return true;
        }

        return false;
    }
}
