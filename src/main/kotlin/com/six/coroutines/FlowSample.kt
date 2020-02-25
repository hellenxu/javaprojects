package main.kotlin.com.six.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * @author hellenxu
 * @date 2020-02-24
 * Copyright 2020 Six. All rights reserved.
 */

fun main() = runBlocking{
    foo().collect {
        println("xxl-$ ait")
    }
}

fun foo(): Flow<Int> = flow {
    for (i in 0..5) {
        delay(100)
        emit(i)
    }
}