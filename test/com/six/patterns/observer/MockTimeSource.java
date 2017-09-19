package com.six.patterns.observer;

/**
 * @author hellenxu
 * @date 2017-09-18
 * Copyright 2017 Six. All rights reserved.
 */
public class MockTimeSource extends Event implements TimeSource {
    private int hours;
    private int minutes;
    private int seconds;

    @Override
    public int getHours() {
        return hours;
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getSeconds() {
        return seconds;
    }

    void setTime(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        notifyObserver();
    }
}
