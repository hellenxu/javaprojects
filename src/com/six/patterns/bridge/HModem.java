package com.six.patterns.bridge;

/**
 * @author hellenxu
 * @date 2017-09-19
 * Copyright 2017 Six. All rights reserved.
 */
public class HModem implements ModemImplementation {
    @Override
    public void dial() {
        System.out.println("HModem dialing...");
    }

    @Override
    public void hangup() {
        System.out.println("HModem hanging up...");
    }

    @Override
    public void send() {
        System.out.println("Data sent by HModem...");
    }

    @Override
    public void receive() {
        System.out.println("HModem received data...");
    }
}
