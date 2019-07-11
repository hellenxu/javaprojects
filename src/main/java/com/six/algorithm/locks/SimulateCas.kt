package com.six.algorithm.locks

/**
 * @author hellenxu
 * @date 2019-07-10
 * Copyright 2019 Six. All rights reserved.
 */
class SimulateCas {
    private var value = 0

    fun getValue(): Int {
        return value
    }

    fun compareAndSwap(expectedValue: Int, newValue: Int): Boolean {
        if (value == expectedValue) {
            value = newValue
            return true
        }
        return false
    }
}