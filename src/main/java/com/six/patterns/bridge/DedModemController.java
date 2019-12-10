package main.java.com.six.patterns.bridge;

/**
 * @author hellenxu
 * @date 2017-09-19
 * Copyright 2017 Six. All rights reserved.
 */
public class DedModemController extends ModemConnectionController {

    DedModemController(ModemImplementation modemImp) {
        super(modemImp);
    }

    @Override
    protected void dialImpl() {
        //simulate dialing...
        System.out.println("DedModemController dialing...");
    }

    @Override
    protected void hangupImpl() {
        //simulate hanging up...
        System.out.println("DedModemController hanging up...");
    }
}
