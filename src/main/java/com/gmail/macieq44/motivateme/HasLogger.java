package com.gmail.macieq44.motivateme;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Macieq44 on 10.12.2017.
 */
public interface HasLogger {

    default Logger getLogger() {
        return LoggerFactory.getLogger(getClass());
    }
}
