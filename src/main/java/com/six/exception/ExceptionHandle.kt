package main.java.com.six.exception

/**
 * @author hellenxu
 * @date 2020-06-03
 * Copyright 2020 Six. All rights reserved.
 */
class ExceptionHandle {

    fun throwRunTimeException() {
        throw RuntimeException("runtime exception")
    }

    fun throwNormalException() {
        throw Exception("normal exception")
    }
}

fun main() {
    val exceptionHandle = ExceptionHandle()

    exceptionHandle.throwRunTimeException()
    exceptionHandle.throwNormalException()
}