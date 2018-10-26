package com.six.patterns.command;

/**
 * @author hellenxu
 * @date 2017-08-11
 * Copyright 2017 Six. All rights reserved.
 */
public class DelayTyper implements Command {
    static boolean isAwake = false;
    private static ActiveEngine engine = new ActiveEngine();
    private long delay;
    private String code;

    private DelayTyper(long delay, String code){
        this.delay = delay;
        this.code = code;
    }

    @Override
    public void execute() {
        if(!isAwake) {
            delayAndRepeat();
        }
        System.out.println(code);
    }

    private void delayAndRepeat() {
        engine.addCommand(new SleepCommand(delay, engine, this));
    }

    public static void main(String[] args) {
        engine.addCommand(new DelayTyper(1000, "code1000"));

        Command wakeup = new WakeupCommand();
        Command sleepCommand = new SleepCommand(6000, engine, wakeup);
        engine.addCommand(sleepCommand);

        engine.run();
    }
}
