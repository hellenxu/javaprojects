package main.kotlin.com.six.algorithm

import kotlin.math.abs

/**
 * @author hellenxu
 * @date 2020-03-12
 * Copyright 2020 Six. All rights reserved.
 */

fun main() {
    removeDups(mutableListOf(10, 9, 10, 11, 12, 1, 1, 1))

    val result = getSubList(mutableListOf(10, 9, 10, 11, 12, 1, 1, 1), 3)
    println("****** SubList ******")
    result.forEach {
        print("$it ")
    }
    println()
}

fun removeDups(input: MutableList<Any?>) {
    println("****** After ******")
    for (i in input) {
        print("$i ")
    }
    println()

    val len = input.size
    var firstPointer = 0
    var fastPointer = 0
    while (firstPointer < len) {
        while (fastPointer < len) {
            if (input[firstPointer] == input[fastPointer]) {
                val offset = abs(fastPointer - firstPointer)
                if (offset > 0) {
                    input[fastPointer] = null
                }
            }
            fastPointer ++
        }

        //reset pointers
        firstPointer ++
        fastPointer = 0
    }



    println("****** After ******")
    for (i in input) {
        if (i != null) {
            print("$i ")
        }
    }
    println()
}

fun getSubList(input: MutableList<Any>, start: Int): MutableList<Any> {
    if (start > input.lastIndex) {
        throw Exception("invalid input: $start")
    }

    val result = mutableListOf<Any>()
    for (index in input.indices) {
        if (index == start) {
            for (i in index .. input.lastIndex) {
                result.add(input[i])
            }
            break
        }
    }

    return result
}