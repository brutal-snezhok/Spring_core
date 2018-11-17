package com.tsyrulik.core.logger.impl;

import com.tsyrulik.core.logger.EventLogger;

public abstract class AbstractLogger implements EventLogger {

    protected String name;

    @Override
    public String getName() {
        return name;
    }
    protected abstract void setName(String name);
}