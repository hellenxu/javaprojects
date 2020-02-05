package main.java.com.six.algorithm

/**
 * @author hellenxu
 * @date 2020-02-04
 * Copyright 2020 Six. All rights reserved.
 */

fun main() {
    println("xxl-check-unique-one: ${checkUniqueOne("qoqu34arouecnq")}")
}

// solution one: nested iteration and compare
// Big O: N*N
fun checkUniqueOne(input: String): Boolean {
    for (i in input.indices) {
        val tmp = input[i]

        for (j in i + 1 .. input.lastIndex) {
            if (tmp == input[j]) {
                return false
            }
        }
    }
    return true
}