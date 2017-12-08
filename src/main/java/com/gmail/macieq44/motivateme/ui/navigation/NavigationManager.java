package com.gmail.macieq44.motivateme.ui.navigation;

import com.gmail.macieq44.motivateme.ui.calendar.CalendarView;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.internal.Conventions;
import com.vaadin.spring.navigator.SpringNavigator;
import org.springframework.stereotype.Component;

/**
 * Created by Macieq44 on 28.11.2017.
 */
@Component
@UIScope
public class NavigationManager extends SpringNavigator {

    public String getViewId(Class<? extends View > viewClass) {
        SpringView springView = viewClass.getAnnotation(SpringView.class);
        if (springView == null) {
            throw new IllegalArgumentException("The target class must be a @SpringView");
        }

        return Conventions.deriveMappingForView(viewClass, springView);
    }

    public void navigateTo(Class<? extends View> targetView) {
        String viewId = getViewId(targetView);
        navigateTo(viewId);
    }

    public void navigateTo(Class<? extends View> targetView, Object parameter) {
        String viewId = getViewId(targetView);
        navigateTo(viewId + "/" + parameter.toString());
    }

    public void navigateToDefaultView() {
        navigateTo(CalendarView.class);
    }
}
