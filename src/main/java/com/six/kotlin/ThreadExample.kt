package com.six.kotlin

import kotlin.concurrent.thread

/**
 * Compare to HelloCoroutines
 */

 fun main(args: Array<String>) {
    val start = System.currentTimeMillis()
    val threads = List(100000) {
        thread {
            Thread.sleep(1000)
            println(Thread.currentThread().name)
        }
    }

    threads.forEach {
        it.join()
    }

    val spend = (System.currentTimeMillis() - start) / 1000
    println("Threads: spend= $spend s")
}


