package com.gmail.macieq44.motivateme.ui;

import com.gmail.macieq44.motivateme.ui.calendar.CalendarView;
import com.gmail.macieq44.motivateme.ui.navigation.NavigationManager;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.navigator.ViewLeaveAction;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Macieq44 on 28.11.2017.
 */
@SpringViewDisplay
@UIScope
public class MainView extends MainViewDesign implements ViewDisplay{

    private final Map<Class<? extends View>, Button> navigationButtons = new HashMap<>();
    private final NavigationManager navigationManager;

    @Autowired
    public MainView(NavigationManager navigationManager) {
        this.navigationManager = navigationManager;
    }

    @PostConstruct
    public void init() {
        attachNavigation(calendar, CalendarView.class);
        //attachNavigation(activities, ActivitiesView.class);
        //attachNavigation(dashboard, Dashboard.class);

        logout.addClickListener(e -> logout());
    }



    private void attachNavigation(Button navigationButton, Class<? extends View> targetView) {
        navigationButtons.put(targetView, navigationButton);
        navigationButton.addClickListener(e -> navigationManager.navigateTo(targetView));
    }

    @Override
    public void showView(View view) {
        content.removeAllComponents();
        content.addComponent(view.getViewComponent());

        navigationButtons.forEach((viewClass, button) -> button.setStyleName("selected", viewClass == view.getClass()));

        //Button menuItem = navigationButtons.get(view.getClass());
        //String viewName = "";
        //if(menuItem != null) {
        //    viewName = menuItem.getCaption();
        //}
        //activeViewName
    }

    private void logout() {
        ViewLeaveAction doLogout = () -> {
            UI ui = getUI();
            ui.getSession().getSession().invalidate();
            ui.getPage().reload();
        };

        navigationManager.runAfterLeaveConfirmation(doLogout);
    }
}
