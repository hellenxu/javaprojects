package main.java.com.six.patterns.command;

import java.util.ArrayList;

/**
 * This is a sample about command pattern.
 * @author hellenxu
 * @date 2017-08-11
 * Copyright 2017 Six. All rights reserved.
 */
public class ActiveEngine {
    private ArrayList<Command> commands = new ArrayList<>();

    void addCommand(Command command) {
        commands.add(command);
    }
    
    void run(){
        while(commands.size() > 0) {
            Command currentCommand = commands.remove(0);
            currentCommand.execute();
        }
    }
}
