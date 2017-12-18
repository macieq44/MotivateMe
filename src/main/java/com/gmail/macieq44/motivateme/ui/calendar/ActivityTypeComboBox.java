package com.gmail.macieq44.motivateme.ui.calendar;

import com.gmail.macieq44.motivateme.HasLogger;
import com.gmail.macieq44.motivateme.backend.entity.ActivityType;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
//import org.vaadin.spring.annotation.PrototypeScope;

import javax.annotation.PostConstruct;

/**
 * Created by Macieq44 on 06.12.2017.
 */
@SpringComponent
@PrototypeScope
public class ActivityTypeComboBox extends ComboBox<ActivityType> implements HasLogger{

    private final ActivityTypeComboBoxDataProvider dataProvider;

    @Autowired
    public ActivityTypeComboBox(ActivityTypeComboBoxDataProvider dataProvider) {
        this.dataProvider = dataProvider;
        setEmptySelectionAllowed(false);
        setTextInputAllowed(false);
        setPlaceholder("Activity type");
        setItemCaptionGenerator(ActivityType::getTypeName);
    }

    @PostConstruct
    private void initDataProvider() {
        setDataProvider(dataProvider);
        getLogger().info("init");
    }
}
