package com.six.patterns;

/**
 * Example of Singleton Pattern
 * Created by hellenxu on 2017-02-16.
 */
public class SingletonSample {
    private static volatile SingletonSample instance;

    public static SingletonSample getInstance(){
        if(instance == null){
            synchronized (SingletonSample.class){
                if (instance == null){
                    instance = new SingletonSample();
                }
            }
        }
        return instance;
    }

    private SingletonSample(){
        // initialization
    }
}
