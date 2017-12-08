package com.gmail.macieq44.motivateme.ui;

import com.gmail.macieq44.motivateme.ui.navigation.NavigationManager;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Macieq44 on 28.11.2017.
 */
@Theme("apptheme")
@SpringUI
@Title("MotivateMe Project")
public class AppUI extends UI {
    private final SpringViewProvider viewProvider;
    private final NavigationManager navigationManager;
    private final MainView mainView;

    @Autowired
    public AppUI(SpringViewProvider viewProvider, NavigationManager navigationManager, MainView mainView) {
        this.viewProvider = viewProvider;
        this.navigationManager = navigationManager;
        this.mainView = mainView;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(mainView);
        navigationManager.navigateToDefaultView();
    }
}
