package com.gmail.macieq44.motivateme.app;

import com.gmail.macieq44.motivateme.backend.entity.Activity;
import com.gmail.macieq44.motivateme.backend.repository.ActivityTypeRepository;
import com.gmail.macieq44.motivateme.backend.service.ActivityService;
import com.gmail.macieq44.motivateme.ui.AppUI;

import com.gmail.macieq44.motivateme.ui.util.LocalDateJpaConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackageClasses = { MotivateMeApplication.class, AppUI.class, ActivityService.class })
@EntityScan(basePackageClasses = { Activity.class, LocalDateJpaConverter.class})
@EnableJpaRepositories(basePackageClasses = { ActivityTypeRepository.class })
public class MotivateMeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MotivateMeApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MotivateMeApplication.class);
	}
}
