package main.java.com.six.patterns.factory;

/**
 * Factories can be of great benefit in conforming to DIP and also make it possible to swap in completely
 * different families of implementations for a group of classes, for example, using factories for test fixtures.
 * But using them by default is seldom the best course of action because of their complexity. -- Quoted from 3P.
 * @author hellenxu
 * @date 2017-09-13
 * Copyright 2017 Six. All rights reserved.
 */
public class ShapeFactory {

    static Shape makeShape(String shapeName) {
        switch (shapeName) {
            case "rectangle":
                return new Rectangle();
            case "circle":
                return new Circle();
            default:
                throw new IllegalArgumentException("do not have shape: " + shapeName);
        }
    }
}
