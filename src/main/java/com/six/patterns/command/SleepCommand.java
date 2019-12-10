package main.java.com.six.patterns.command;

/**
 * @author hellenxu
 * @date 2017-08-11
 * Copyright 2017 Six. All rights reserved.
 */
public class SleepCommand implements Command{
    private long delay;
    private ActiveEngine engine;
    private Command wakeup;
    private long startTime;
    private boolean isStarted = false;

    SleepCommand(long delay, ActiveEngine engine, Command wakeupCommand){
        this.delay = delay;
        this.engine = engine;
        this.wakeup = wakeupCommand;
    }

    @Override
    public void execute() {
        if(!isStarted) {
            engine.addCommand(this);
            isStarted = true;
            startTime = System.currentTimeMillis();
        } else {
            long elapsedTime = System.currentTimeMillis() - startTime;
            if(elapsedTime > delay) {
                engine.addCommand(wakeup);
            } else {
                engine.addCommand(this);
            }
        }
    }
}
