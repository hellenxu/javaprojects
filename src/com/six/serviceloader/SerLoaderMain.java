package com.six.serviceloader;

import java.util.ServiceLoader;

/**
 * Created by Xiaolin on 2017-04-20.
 */
public class SerLoaderMain {

    public static void main(String[] args){
        ServiceLoader<IService> services = ServiceLoader.load(IService.class);
        for(IService ser : services){
            System.out.println(ser.getName() + " : " + ser.greeting());
        }
    }
}
