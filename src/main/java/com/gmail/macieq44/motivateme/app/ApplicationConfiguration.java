package com.gmail.macieq44.motivateme.app;

import com.vaadin.spring.access.SecuredViewAccessControl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Macieq44 on 28.11.2017.
 */
@Configuration
public class ApplicationConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecuredViewAccessControl securedViewAccessControl() {
        return new SecuredViewAccessControl();
    }
}
