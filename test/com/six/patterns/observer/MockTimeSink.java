package com.six.patterns.observer;

/**
 * @author hellenxu
 * @date 2017-09-18
 * Copyright 2017 Six. All rights reserved.
 */
public class MockTimeSink implements Observer {
    private int hours;
    private int minutes;
    private int seconds;
    private TimeSource source;

    MockTimeSink(TimeSource source) {
        this.source = source;
    }

    int getHours() {
        return hours;
    }

    int getMinutes() {
        return minutes;
    }

    int getSeconds() {
        return seconds;
    }

    @Override
    public void update() {
        hours = source.getHours();
        minutes = source.getMinutes();
        seconds = source.getSeconds();
    }
}
