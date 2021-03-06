package main.java.com.six.patterns.bridge;

/**
 * New requirements:
 * 1) Add dedicated modems which don't dial;
 * 2) All modem clients are able to use the dedicated modems;
 * 3) No changes are allowed in modem clients.
 * @author hellenxu
 * @date 2017-09-19
 * Copyright 2017 Six. All rights reserved.
 */
public class ModemClient {

    void connection(Modem modem) {
        //send data to others
        modem.send();

        //receive necessary data
        modem.receive();
    }

    void communication(Modem modem) {
        modem.dial();
        //do something else...
        modem.hangup();
        //do other things...
    }
}
