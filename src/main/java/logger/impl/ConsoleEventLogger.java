package logger.impl;

import beans.Event;
import logger.EventLogger;

public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event){
        System.out.println(event.toString());
    }

}