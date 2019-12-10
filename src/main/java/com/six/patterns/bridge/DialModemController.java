package main.java.com.six.patterns.bridge;

/**
 * @author hellenxu
 * @date 2017-09-19
 * Copyright 2017 Six. All rights reserved.
 */
public class DialModemController extends ModemConnectionController {

    DialModemController(ModemImplementation modemImp) {
        super(modemImp);
    }

    @Override
    protected void dialImpl() {
        modemImp.dial();
    }

    @Override
    protected void hangupImpl() {
        modemImp.hangup();
    }
}
