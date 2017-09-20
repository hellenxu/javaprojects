package com.six.patterns.bridge;

/**
 * @author hellenxu
 * @date 2017-09-19
 * Copyright 2017 Six. All rights reserved.
 */
public interface ModemImplementation {

    void dial();
    void hangup();
    void send();
    void receive();
}
