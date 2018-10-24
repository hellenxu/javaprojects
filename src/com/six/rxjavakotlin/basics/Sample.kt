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
        emitter.onComplete()

        if(random.nextBoolean()) {
            if(!emitter.isDisposed)
            emitter.onSuccess("logged in")

        } else {
            if(!emitter.isDisposed)
            emitter.onError(Error("http error"))
        }
    }
}