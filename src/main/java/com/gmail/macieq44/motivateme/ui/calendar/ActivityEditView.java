package com.gmail.macieq44.motivateme.ui.calendar;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Macieq44 on 06.12.2017.
 */
@SpringView
public class ActivityEditView extends ActivityEditViewDesign implements View{
    private final ActivityEditPresenter presenter;

    @Autowired
    public ActivityEditView(ActivityEditPresenter presenter) {
        this.presenter = presenter;
    }

    @PostConstruct
    private void init() {
        presenter.setView(this);
    }
}
