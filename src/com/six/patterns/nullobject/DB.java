package com.six.patterns.nullobject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author hellenxu
 * @date 2017-09-12
 * Copyright 2017 Six. All rights reserved.
 */
public class DB {
    private static HashMap<Integer, Employee> employees = new LinkedHashMap<>();

    public static void main(String[] args) {
    //init
        employees.put(1, new EmployeeImpl());
        employees.put(3, new EmployeeImpl());
        employees.put(5, new EmployeeImpl());

        //inquiry employee
        Employee e = getEmployee(0);
        if (e.equals(Employee.NULL_EMPLOYEE)){
            e.pay();
        }

        Employee e0 = getEmployee(11);
        if(e.equals(e0)){
            e0.pay();
        }

        Employee e1 = getEmployee(1);
        if (e1.isTimeToPay(Calendar.getInstance().getTime())){
            e1.pay();
        }
    }

    private static Employee getEmployee(int id){
        return employees.getOrDefault(id, Employee.NULL_EMPLOYEE);
    }
}
