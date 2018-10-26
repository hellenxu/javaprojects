package com.six.patterns.bridge;

/**
 * @author hellenxu
 * @date 2017-09-19
 * Copyright 2017 Six. All rights reserved.
 */
public abstract class ModemConnectionController implements Modem, DedicatedModem {
    ModemImplementation modemImp;

    ModemConnectionController(ModemImplementation modemImp) {
        this.modemImp = modemImp;
    }

    protected abstract void dialImpl();

    protected abstract void hangupImpl();

    protected void sendImpl() {
        modemImp.send();
    }

    protected void receiveImpl() {
        modemImp.receive();
    }

    @Override
    public void dial() {
        dialImpl();
    }

    @Override
    public void hangup() {
        hangupImpl();
    }

    @Override
    public void send() {
        sendImpl();
    }

    @Override
    public void receive() {
        receiveImpl();
    }
}
