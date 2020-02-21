package main.java.com.six.algorithm

import io.reactivex.Maybe
import kotlin.math.abs

/**
 * @author hellenxu
 * @date 2020-02-04
 * Copyright 2020 Six. All rights reserved.
 */

fun main() {
    println("xxl-check-unique-one: ${checkUniqueOne("qoqu34arouecnq")}")
    println("xxl-check-unique-two: ${checkUniqueTwo("qoqu34arouecnq")}")
    println("xxl-check-unique-three: ${checkUniqueThree("qoqu34arouecnq")}")
    println("xxl-check-permutation-one: ${checkPermutation("1qazxsw23edc", "cxzasde32w1q")}")
    println("xxl-replace: ${replace("12 2haoa  o20   ", "%20")}")
    println("xxl-check-palindrome-permutation: ${checkPalindromePermutation("taco cat")}")
    println("xxl-check-palindrome-permutation: ${checkPalindromePermutation("tacocat")}")
    println("xxl-check-one-away: ${checkOneAway("pale", "ple")}")
    println("xxl-check-one-away: ${checkOneAway("pales", "pale")}")
    println("xxl-check-one-away: ${checkOneAway("pale", "bale")}")
    println("xxl-check-one-away: ${checkOneAway("pale", "bake")}")

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

// solution one: use arrays [assume it only includes standard ASCII]
// Big O: 2* N
fun checkPermutation(source: String, target: String): Boolean {
    if (source.length != target.length) {
        return false
    }

    val tmp = Array(128) { 0 }
    for (i in source.indices) {
        val index = source[i].toInt()
        tmp[index]++
    }

    for (i in target.indices) {
        val index = target[i].toInt()
        tmp[index]--
        if (tmp[index] < 0) {
            return false
        }
    }

    return true
}

// solution one: calculate the amount of space to set the size of result array, then set value
// Big O: N + N + a*b
fun replace(input: String, replace: String): String {
    println("xxl-before: $input")
    var spaceCount = 0
    for (i in input) {
        if (i == ' ') {
            spaceCount ++
        }
    }
    val size = input.length + spaceCount * replace.length
    val result = Array(size) {' '}
    for (i in input.indices) {
        val tmp = input[i]
        val lastIndex = result.indexOfLast { it != ' ' }
        val index: Int = if (lastIndex < 0) { 0} else lastIndex + 1
        if (tmp == ' ') {
            for (j in replace.indices) {
                result[index + j] = replace[j]
            }
        } else {
            result[index] = tmp
        }
    }

    return result.joinToString("")
}

// Solution: create an array which accepts char from the last one to the first one
// Big O: N
fun checkPalindromePermutation(input: String): Boolean {
    val len = input.length
    val backwards = Array(len) {' '}
    val lastIndex = input.lastIndex

    for (i in 0 until len) {
        backwards[i] = input[lastIndex - i]
    }

    if (backwards.joinToString("") == input) {
        return true
    }

    return false
}

fun checkOneAway(input1: String, input2: String): Boolean {
    if (abs(input1.length - input2.length) > 1) {
        return false
    }

    val tmp1 = Array(128) {0}
    for (i in input1) {
        val index = i.toInt()
//        println("xxl-input1: $index")
        tmp1[index] ++
    }

    val tmp2 = Array(128) {0}
    for (i in input2) {
        val index = i.toInt()
//        println("xxl-input2: $index")
        tmp2[index] ++
    }

    var awayCount = 0
    for (i in tmp1.indices) {
        if (abs(tmp1[i] - tmp2[i]) > 0) {
//            println("xxl-tmp: $i; ${tmp1[i]}; ${tmp2[i]}")
            awayCount ++
        }
//        println("xxl-count: $awayCount")
        if (awayCount > 2 || (awayCount == 2 && input1.length != input2.length)) {
            return false
        }
    }

    return true
}