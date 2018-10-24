package com.six.rxjavakotlin.basics

import io.reactivex.Maybe
import io.reactivex.Single
import java.util.*

fun main(args: Array<String>) {
    isUserExistMaybe().subscribe({ response ->
        println("xxl-success: $response")
    }, {error -> println("xxl-$error")}, { println("xxl-onComplete")})

    isUserExistSingle().subscribe({ response ->
        println("xxl-success: $response")
    }, {error -> println("xxl-$error")})
}

fun isUserExistMaybe(): Maybe<String> {
    val random = Random()

    return  Maybe.create {emitter ->
        emitter.onComplete()

        if(random.nextBoolean()) {
            if(!emitter.isDisposed)
            emitter.onSuccess("logged in: maybe")

        } else {
            if(!emitter.isDisposed)
            emitter.onError(Error("http error: maybe"))
        }
    }
}

fun isUserExistSingle(): Single<String> {
    val random = Random()

    return Single.create { emitter ->
        if(random.nextBoolean()) {
            emitter.onSuccess("logged in: single")
        } else {
            emitter.onError(Error("http error: single"))
        }
    }
}