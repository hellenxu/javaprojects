package com.six.kotlin

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

//fun main(args: Array<String>) {
//
//    /**
//     * 1) main thread created;
//     * 2) one coroutine created and delayed 1s;
//     * 3) Hello is printed;
//     * 4) After 1s, World! is printed.
//     */
//    launch(CommonPool) {
//        delay(1000L)
//        println("World!")
//    }
//
//    print("Hello ")
//    Thread.sleep(2000L)
//}


/**
 * runBlocking example
 */
//fun main(args: Array<String>) = runBlocking<Unit> {
//    launch(CommonPool) {
//        delay(1000L)
//        println("World!")
//    }
//
//    print("Hello ")
//    delay(2000L)
//}

/**
 * Job example
 */
//fun main(args: Array<String>) = runBlocking<Unit> {
//    var job = launch(CommonPool) {
//        delay(1000L)
//        println("World!")
//    }
//
//    print("Hello ")
//    job.join()
//}


/**
 * create suspending function
 */
fun main(args: Array<String>) = runBlocking<Unit>{
    val job = launch(CommonPool) {
        printWorld()
    }

    print("Hello ")
    job.join()
}

suspend fun printWorld() {
    delay(1000L)
    println("World!")
}
