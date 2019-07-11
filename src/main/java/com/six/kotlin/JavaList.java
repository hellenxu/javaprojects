package main.java.com.six.kotlin;

import java.util.ArrayList;
import java.util.List;

public class JavaList {
    private List<Animal> animals = new ArrayList<>();
    private List<Dog> dogs = new ArrayList<>();

    public void sample() {
        animals = dogs;
    }
}

class Animal {}

class Dog extends Animal {}