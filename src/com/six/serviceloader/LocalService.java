package com.six.serviceloader;

/**
 * Created by Xiaolin on 2017-04-20.
 */
public class LocalService implements IService {
    @Override
    public String getName() {
        return LocalService.class.getSimpleName();
    }

    @Override
    public String greeting() {
        return "Hello from LS...";
    }
}
