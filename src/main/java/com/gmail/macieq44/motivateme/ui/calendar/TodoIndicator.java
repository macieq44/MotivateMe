package com.gmail.macieq44.motivateme.ui.calendar;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;

/**
 * Created by Macieq44 on 10.12.2017.
 */
@SpringComponent
@UIScope
public class TodoIndicator extends Label {

    public TodoIndicator(String color) {
        super(VaadinIcons.CIRCLE.getHtml(), ContentMode.HTML);

        addStyleName(color);
    }
}
