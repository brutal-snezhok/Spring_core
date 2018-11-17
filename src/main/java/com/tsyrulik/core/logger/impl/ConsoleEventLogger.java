package com.tsyrulik.core.logger.impl;

import com.tsyrulik.core.beans.Event;
import com.tsyrulik.core.logger.EventLogger;
import org.springframework.stereotype.Component;

@Component
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event){
        System.out.println(event.toString());
    }

}