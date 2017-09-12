package com.six.patterns.nullobject;


import java.util.Date;

/**
 * @author hellenxu
 * @date 2017-09-12
 * Copyright 2017 Six. All rights reserved.
 */
public class EmployeeImpl implements Employee {

    @Override
    public boolean isTimeToPay(Date date) {
        return date.getDate() > 10;
    }

    @Override
    public void pay() {
        System.out.println("Employee: paid done...");
    }
}
