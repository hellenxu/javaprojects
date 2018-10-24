package com.six.rxjavakotlin.basics

import io.reactivex.*
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.*

fun main(args: Array<String>) {
//    isUserExistMaybe().subscribe({ response ->
//        println("xxl-success: $response")
//    }, {error -> println("xxl-$error")}, { println("xxl-onComplete")})
//
//    isUserExistSingle().subscribe({ response ->
//        println("xxl-success: $response")
//    }, {error -> println("xxl-$error")})
//
//    isUserExistCompletable().subscribe(
//            { println("xxl-onComplete: completable")},
//            { error -> println("xxl-$error")}
//    )

//    completableAndThen()
    backPressure()
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

fun isUserExistCompletable(): Completable {
    val random = Random()

    return Completable.create {emitter ->
        if(random.nextBoolean()) {
            emitter.onComplete()
        } else {
            emitter.onError(Error("http error: completable"))
        }
    }
}

fun completableAndThen() {
    Completable.create { emitter ->
        emitter.onComplete()
    }
            .andThen(Flowable.range(1, 10))
            .subscribe {
                println("xxl-completable: $it")
            }
}

fun backPressure() {
    val observable = PublishSubject.create<Int>()
    observable.toFlowable(BackpressureStrategy.MISSING)
            .observeOn(Schedulers.computation())
            .subscribe({
                println("xxl-onNext: $it")
            }, {
                println("xxl-onError: $it")
            })

    for(i in 0..200000000) {
        observable.onNext(i)
    }
}