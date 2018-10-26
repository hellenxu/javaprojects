package com.six.patterns.nullobject;

import java.util.Date;

/**
 * @author hellenxu
 * @date 2017-09-12
 * Copyright 2017 Six. All rights reserved.
 */
public interface Employee {

    boolean isTimeToPay(Date date);
    void pay();
    NullEmployee NULL_EMPLOYEE = new NullEmployee();

    class NullEmployee implements Employee {

        @Override
        public boolean isTimeToPay(Date date) {
            return false;
        }

        @Override
        public void pay() {
            System.out.println("Null Employee: do nothing...");
        }
    }
}
