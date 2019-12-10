package main.java.com.six.patterns.command;

/**
 * @author hellenxu
 * @date 2017-08-11
 * Copyright 2017 Six. All rights reserved.
 */
public class WakeupCommand implements Command {

    @Override
    public void execute() {
        DelayTyper.isAwake = true;
        System.out.println("wake up...");
    }
}
