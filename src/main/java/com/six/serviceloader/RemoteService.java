package com.six.serviceloader;

/**
 * Created by Xiaolin on 2017-04-20.
 */
public class RemoteService implements IService {
    @Override
    public String getName() {
        return RemoteService.class.getSimpleName();
    }

    @Override
    public String greeting() {
        return "Hello from RS...";
    }
}
