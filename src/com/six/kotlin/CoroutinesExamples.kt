package com.six.kotlin

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

fun main(args: Array<String>) {

    /**
     * 1) main thread created;
     * 2) one coroutine created and delayed 1s;
     * 3) Hello is printed;
     * 4) After 1s, World! is printed.
     */
    launch(CommonPool) {
        delay(1000L)
        println("World!")
    }

    print("Hello ")
    Thread.sleep(2000L)
}