package com.six.rxjavakotlin.basics

import io.reactivex.*
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
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
//    intervalSam()
//    takeWhileSam()
//    concatCheck()
//    zipSample()
//    mergeSample()
//    scanSample()
    distinct()
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

//takeWhile == take until the condition is not satisfied;
//filter == filter items that doesn’t satisfy the condition.
fun takeWhileSam() {
    val data = arrayOf("ab", "5", "ad", "bb0", "ca9", "da")
    Observable.fromArray(*data)
            .takeWhile {it.length > 1}
            .subscribe { println("xxl-chosen: $it") }

    Observable.fromArray(*data)
            .filter { it.length > 2 }
            .subscribe { println("xxl-filtered: $it") }
}

fun concatCheck() {
    val seed = Random()
    val isFromMemory = seed.nextBoolean()
    var isFromDisk = false

    val memoryObservable = Observable.create<String> {
        if(isFromMemory){
            it.onNext("memory cached")
            println("xxl-memory-onNext")
        } else {
            isFromDisk = true
            it.onComplete()
            println("xxl-memory-onComplete")
        }
    }

    val diskObservable = Observable.create<String> {
        if(isFromDisk && seed.nextBoolean()) {
            it.onNext("disk cached")
            println("xxl-disk-onNext")
        } else {
            it.onComplete()
            println("xxl-disk-onComplete")
        }
    }

    val netObservable = Observable.just("net fetching...")

    Observable.concat(memoryObservable, diskObservable, netObservable)
            .subscribe {
                println("xxl-result: $it")
            }

}

fun zipSample() {
    val array1 = arrayOf("ac", "erw", "er")
    val array2 = arrayOf("ba", "tt")
    Observable.zip(Observable.fromArray(array1),
            Observable.fromArray(array2),
            BiFunction<Array<String>, Array<String>, ArrayList<String>> { t1, t2 ->
                val minSize = Math.min(t1.size, t2.size)
                val resultList = ArrayList<String>()
                for (i in 0 until minSize) {
                    resultList.add(t1[i] + t2[i])
                }
                resultList
            }).subscribe { result -> println("xxl-size: ${result.size}") }
}

fun mergeSample() {
    val ob1 = Observable.just("098")
    val ob2 = Observable.just("345")
    Observable.merge(ob1, ob2)
            .subscribe {
                println("xxl-merge: $it")
            }
}

fun scanSample() {
    Observable.just(1, 3, 5, 7, 9)
            .scan { sum: Int, item: Int -> sum + item }
            .subscribe {
                println("xxl-subscribe: $it")
            }
}

fun distinct() {
    Observable.just(1, 2, 3, 4,4, 5, 6)
            .distinct()
            .subscribe {
                println("xxl-distinct-filtered: $it")
            }

    Observable.just(1, 2, 3, 4,4, 3, 6)
            .distinctUntilChanged()
            .subscribe {
                println("xxl-distinctUntilChanged: $it")
            }
}