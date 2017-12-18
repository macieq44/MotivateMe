package com.gmail.macieq44.motivateme.ui.calendar;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class ActivityEditPresenter {
    private ActivityEditView view;

    @Autowired
    public ActivityEditPresenter() {
    }

    public void setView(ActivityEditView view) {
        this.view = view;
    }
}
