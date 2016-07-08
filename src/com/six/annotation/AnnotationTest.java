package com.six.annotation;

/**
 * Created by Xiaolin on 2016-07-07.
 */

public class AnnotationTest {

    @HelloAnnotation(greeting = "Good Morning")
    public static void main(String[] args){
        System.out.println("Using custom annotation...");
    }
}
