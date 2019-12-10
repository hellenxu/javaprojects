package main.java.com.six.patterns.bridge;

/**
 * @author hellenxu
 * @date 2017-09-19
 * Copyright 2017 Six. All rights reserved.
 */
public class DedUser {

    void connection(DedicatedModem modem) {
        //send data to others
        modem.send();

        //receive necessary data
        modem.receive();
    }
}
