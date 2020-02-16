package main.java.com.six.algorithm

import io.reactivex.Maybe
import io.reactivex.MaybeEmitter

/**
 * @author hellenxu
 * @date 2020-02-04
 * Copyright 2020 Six. All rights reserved.
 */

fun main() {
    println("xxl-check-unique-one: ${checkUniqueOne("qoqu34arouecnq")}")
    println("xxl-check-unique-two: ${checkUniqueTwo("qoqu34arouecnq")}")
    println("xxl-check-unique-three: ${checkUniqueThree("qoqu34arouecnq")}")

    /**
     * with return
     * xxl-error: java.lang.Throwable: 2
     * without return
     * xxl-error: java.lang.Throwable: 2
     * xxl-middle
     */
    Maybe.create<Int> { emitter ->
        if (true) {
            emitter.onError(Throwable("2"))
            return@create
        }
        println("xxl-middle")
        emitter.onSuccess(1)
    }
        .subscribe({
            println("xxl-success: $it")
        }, {
            println("xxl-error: $it")
        })
}

// solution one: nested iteration and compare
// Big O: N*N
fun checkUniqueOne(input: String): Boolean {
    val start = System.currentTimeMillis()
    for (i in input.indices) {
        val tmp = input[i]

        for (j in i + 1 .. input.lastIndex) {
            if (tmp == input[j]) {
                println("xxl-unique-one-cost: ${System.currentTimeMillis() - start} ms")
                return false
            }
        }
    }
    println("xxl-unique-one-cost: ${System.currentTimeMillis() - start} ms")
    return true
}

// solution two: hash table
// Big O: N
fun checkUniqueTwo(input: String): Boolean {
    val start = System.currentTimeMillis()
    val tmp = hashMapOf<Int, Char>()
    for (i in input.indices) {
        val value = input[i]
        val key = input[i].hashCode()
        if (tmp.containsKey(key) && tmp[key] == value) {
            println("xxl-unique-two-cost: ${System.currentTimeMillis() - start} ms")
            return false
        } else {
            tmp[key] = value
        }
    }
    println("xxl-unique-two-cost: ${System.currentTimeMillis() - start} ms")
    return true
}

// solution three: use an array [assume it only includes standard ASCII]
// Big O: N
fun checkUniqueThree(input: String): Boolean {
    val start = System.currentTimeMillis()
    val tmp = Array(128) {false}
    for (i in input) {
        val index = i.toInt()
        if (tmp[index]) {
            println("xxl-unique-three-cost: ${System.currentTimeMillis() - start} ms")
            return false
        }
        tmp[index] = true
    }
    println("xxl-unique-three-cost: ${System.currentTimeMillis() - start} ms")
    return true
}

