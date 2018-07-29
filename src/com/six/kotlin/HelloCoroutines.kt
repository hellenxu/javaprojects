package com.six.kotlin

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    val start = System.currentTimeMillis()
    runBlocking {
        val jobs = List(100000) {
            launch(CommonPool) {
                delay(1000)
                println("thread name= " + Thread.currentThread().name)
            }
        }

        jobs.forEach {
            it.join()
        }
    }

    val spend = (System.currentTimeMillis() - start) / 1000

    println("Coroutines: spend=$spend s")
}