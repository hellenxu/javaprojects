package main.java.com.six.patterns.factory;

/**
 * @author hellenxu
 * @date 2017-09-13
 * Copyright 2017 Six. All rights reserved.
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("I am a circle...");
    }
}
