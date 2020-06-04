package main.java.com.six.exception;

/**
 * @author hellenxu
 * @date 2020-06-03
 * Copyright 2020 Six. All rights reserved.
 */
public class Sample {

    public static void main(String[] args) {
        throwRunTimeException();
        try {
            throwNormalException();
        }catch (Exception e) {
            System.out.println("xxl-normal-exception: " + e);
        }
    }

    private static void throwRunTimeException() {
        throw new RuntimeException("I am runtime exception.");
    }

    private static void throwNormalException() throws Exception {
        throw new Exception("I am normal exception.");
    }
}
