package com.six.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hellenxu
 * @date 2017-09-18
 * Copyright 2017 Six. All rights reserved.
 */
public class Event {
    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
