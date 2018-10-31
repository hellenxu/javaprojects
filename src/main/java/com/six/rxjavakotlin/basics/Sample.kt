package com.six.rxjavakotlin.basics

import io.reactivex.*
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.*
import java.util.concurrent.TimeUnit

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
//    backPressure()
//    flowable()
//    nestedLoop()
//    justSample()
//    create()
//    takeSample()
//    repeat()
//    timer()
//    delayExample()
    intervalSam()
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

//flowable backPressure strategy
fun flowable() {
    val subscriber = object : Subscriber<Int> {
        var subscription: Subscription? = null

        override fun onComplete() {
            println("xxl-flowable-onComplete")
        }

        override fun onSubscribe(s: Subscription?) {
            subscription = s
            subscription?.request(1)
            println("xxl-subscription: $s")
        }

        override fun onNext(t: Int?) {
            subscription?.request(1)
            println("xxl-onNext: $t")
        }

        override fun onError(t: Throwable?) {
            println("xxl-onError: $t")
        }

    }

    Flowable.range(0, 15)
            .subscribe(subscriber)

}

fun nestedLoop() {
    Observable.range(0, 2)
            .doAfterNext {
                println("xxl-layer1: $it")
            }.flatMap { index ->
                println("xxl-index: $index")
                Observable.range(0, 3)
                        .doOnNext { j ->
                            println("xxl-layer2: $j")
                        }
            }.subscribe()
}

fun justSample() {
    val data = "hello hah"
    Observable.just(data)
            .subscribe { println("xxl-just-item: $it") }

    Observable.just(data, true, Arrays.asList(1, 3, 5, 7, 9), Cici("title1", "history00"))
            .subscribe {
                println("xxl-just-multiple-item: $it")
            }
}

fun create() {
    Observable.create<String> { emitter ->
        emitter.onNext("te1")
        emitter.onNext("te6")
        emitter.onNext("te5")
        emitter.onNext("te4")
        emitter.onComplete()

    }.subscribe {
        println("xxl-onNext: $it")
    }.dispose()
}

fun takeSample() {
    val data = arrayOf("t0", "", "", "t1", "", "t2", "t3")
    Observable.fromArray(*data)
            .filter {
                it.length >= 2
            }.subscribe {
                println("xxl-result: $it")
            }
//    Observable.just(
//        data.filter {
//            it.isNotEmpty()
//        }.take(2)
//    ).subscribe {
//        println("xxl-result: $it")
//    }
}

fun repeat() {
    Observable.just("te2", "to0", "te3")
            .repeat(2)
            .subscribe {
                println("xxl-item: $it")
            }
}

fun timer() {
    Observable.timer(3, TimeUnit.SECONDS, Schedulers.trampoline())
            .flatMap {
                println("xxl-timer: $it")
                Observable.just("timer00")
            }
            .subscribe { println("xxl-subscribe: $it") }
}

fun delayExample() {
    Observable.just("delay()")
            .delay(3, TimeUnit.SECONDS, Schedulers.trampoline())
            .subscribe { println("xxl-subscribe: $it") }
}

fun intervalSam() {
    Observable.interval(2, TimeUnit.SECONDS, Schedulers.trampoline())
            .subscribe {
                println("xxl-interval: $it")
            }
}