package com.six.rxjavakotlin.basics

import io.reactivex.Maybe
import java.util.*

fun main(args: Array<String>) {
    isUserExist().subscribe({response ->
        println("xxl-success: $response")
    }, {error -> println("xxl-$error")}, { println("xxl-onComplete")})
}

fun isUserExist(): Maybe<String> {
    val random = Random()

    return  Maybe.create {emitter ->
        if(random.nextBoolean()) {
            emitter.onSuccess("logged in")
        } else {
            emitter.onError(Error("http error"))
        }
    }
}