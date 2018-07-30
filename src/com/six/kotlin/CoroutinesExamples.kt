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
//fun main(args: Array<String>) = runBlocking<Unit>{
//    val job = launch(CommonPool) {
//        printWorld()
//    }
//
//    print("Hello ")
//    job.join()
//}
//
//suspend fun printWorld() {
//    delay(1000L)
//    println("World!")
//}


/**
 * cancel Coroutines example
 */
//fun main(args: Array<String>) = runBlocking<Unit>{
//    //以下的job不断重复，直到完成重复次数1000或者主协程结束;
//    //主协程delay 1300L的过程中, job可以重复3次;然后job.cancel()被执行
//    val job = launch(CommonPool) {
//        repeat(1000) {
//            println("I'm sleeping $it")
//            delay(500L)
//        }
//    }
//
//    delay(1300L)
//    println("main: I'm tired of waiting!")
//    job.cancel()
//    delay(1300L)
//    println("main: Now I can quit.")
//}

/**
 * non-cancellable coroutines example
 */
fun main(args: Array<String>) = runBlocking<Unit>{
    val job = launch(CommonPool) {
        var nextPrintTime = 0L
        var i = 0
        while(i < 10) {
            val currentTime = System.currentTimeMillis()
            if(currentTime >= nextPrintTime) {
                println("I'm sleeping ${i++}")
                nextPrintTime = currentTime + 500L
            }
        }
    }

    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancel()
    delay(1300L)
    println("main: Now I can quit.")
}

