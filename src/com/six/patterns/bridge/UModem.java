package com.six.patterns.bridge;

/**
 * @author hellenxu
 * @date 2017-09-19
 * Copyright 2017 Six. All rights reserved.
 */
public class UModem implements Modem {
    @Override
    public void dial() {
        System.out.println("UModem dialing...");
    }

    @Override
    public void hangup() {
        System.out.println("UModem hanging up...");
    }

    @Override
    public void send() {
        System.out.println("Data sent by UModem...");
    }

    @Override
    public void receive() {
        System.out.println("UModem received data...");
    }
}
