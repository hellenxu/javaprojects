package main.java.com.six.kotlin;

import java.util.ArrayList;
import java.util.List;

public class JavaList {
    private List<Animal> animals = new ArrayList<>();
    private List<? extends Animal> dogs = new ArrayList<Dog>();

    public void sample() {
//        animals = dogs; //still have incompatible type error
        dogs = animals;
    }
}

class Animal {}

class Dog extends Animal {}