package com.six.patterns.bridge;

/**
 * @author hellenxu
 * @date 2017-09-19
 * Copyright 2017 Six. All rights reserved.
 */
public class EModem implements Modem {
    @Override
    public void dial() {
        System.out.println("EModem dialing...");
    }

    @Override
    public void hangup() {
        System.out.println("EModem hanging up...");
    }

    @Override
    public void send() {
        System.out.println("Data sent by EModem...");
    }

    @Override
    public void receive() {
        System.out.println("EModem received data...");
    }
}
