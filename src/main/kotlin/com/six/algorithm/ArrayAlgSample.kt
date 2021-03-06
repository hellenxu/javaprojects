package main.kotlin.com.six.algorithm

import io.reactivex.Maybe
import kotlin.math.abs
import kotlin.math.max

/**
 * @author hellenxu
 * @date 2020-02-04
 * Copyright 2020 Six. All rights reserved.
 */

fun main() {
//    println("xxl-check-unique-one: ${checkUniqueOne("qoqu34arouecnq")}")
//    println("xxl-check-unique-two: ${checkUniqueTwo("qoqu34arouecnq")}")
//    println("xxl-check-unique-three: ${checkUniqueThree("qoqu34arouecnq")}")
//    println("xxl-check-permutation-one: ${checkPermutation(
//        "1qazxsw23edc",
//        "cxzasde32w1q"
//    )}")
//    println("xxl-replace: ${replace("12 2haoa  o20   ", "%20")}")
//    println("xxl-check-palindrome-permutation: ${checkPalindromePermutation(
//        "taco cat"
//    )}")
//    println("xxl-check-palindrome-permutation: ${checkPalindromePermutation(
//        "tacocat"
//    )}")
//    println("xxl-check-one-away: ${checkOneAway("pale", "ple")}")
//    println("xxl-check-one-away: ${checkOneAway("pales", "pale")}")
//    println("xxl-check-one-away: ${checkOneAway("pale", "bale")}")
//    println("xxl-check-one-away: ${checkOneAway("pale", "bake")}")
//    println("xxl-string-compression: ${compressStr("aabcccccaaa")}")

    println("xxl-check-string-rotation: ${checkRotation("erbottlewat", "waterbottle")}")
    println("xxl-check-string-rotation: ${checkRotation("abcddd", "dabcd")}")
    println("xxl-check-string-rotation: ${checkRotationTwo("abcdefg", "efgabcd")}")

    val array1 = arrayOf(1,1,1,1,1)
    val array2 = arrayOf(1,4,0,1,2)
    val array3 = arrayOf(1,4,1,0,2)
    val array4 = arrayOf(1,3,3,3,2)
    val array5 = arrayOf(1,1,1,1,1)
    val matrix = arrayOf(array1, array2, array3, array4, array5)
    rotateImage(matrix)
    resetMatrix(matrix)

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

// Solution:
// 1) length offset is less than 2;
// 2) awayCount should less or equal to 2; if awayCount == 2, length of two strings should be the same
// Big O: N + N + 128
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

// Solution: use flags
// Big O: N * N
fun compressStr(input: String): String {
    val result = StringBuilder()
    val len = input.length
    var index = 0
    var count = 0
    while (index < len) {
        val tmp = input[index]
        result.append(tmp)

        for (i in index until len) {
            if (tmp == input[i]) {
                count ++
                if ((index + count) == len) {
                    result.append(count)
                    index += count
                }
            } else {
                result.append(count)
                index = i
                count = 0
                break
            }
        }
    }

    return result.toString()
}

// only with subString, check whether input2 is a rotation of input1
// Big O: 0 + 1 + 2 .. + n = n(n + 1) / 2
fun checkRotation(input1: String, input2: String): Boolean {
    if (input1.length != input2.length || input1.isEmpty() || input2.isEmpty()) {
        return false
    }

    var edgeIndex = 0
    for (i in edgeIndex .. input2.lastIndex) {
        val tmp = input2.substring(edgeIndex)
        if (input1.indexOf(tmp) == -1) {
            edgeIndex ++
        } else {
            break
        }
    }

    val len = input1.length
    val firstPart = input2.substring(0, edgeIndex)
    val secondPart = input2.substring(edgeIndex, input2.lastIndex)
    when(firstPart.length) {
        0, len -> { if (input1 == input2) return true}
        else -> {if (input1.indexOf(firstPart) != -1 && input1.indexOf(secondPart) != -1) return true}
    }

    return false
}

// only with subString, check whether input2 is a rotation of input1
// Solution two: s1 = xy, s2 = yx ==> s2 is a substring of xyxy, which is s1s1
fun checkRotationTwo(input1: String, input2: String): Boolean {
    val len = input1.length
    if (len == input2.length && len > 0) {
        val s1s1 = input1 + input2
        return s1s1.indexOf(input2) > -1
    }
    return false
}

// Solution:
// Big O: (N/2 -1) + (N/2 - 2) + ... + 1 = N * (N/2 - 1)/4 
fun rotateImage(imgMatrix: Array<Array<Int>>) {
    println("****** RotateImage ******")
    println("****** Before ******")
    for (i in imgMatrix.indices) {
        for (j in imgMatrix[i]) {
            print("$j ")
        }
        println("")
    }

    val len = imgMatrix.size
    val layerAmt = len / 2
    for(i in 0 until layerAmt) {
        val first = i // first index
        val last = len - 1 - i // last index
        for (j in first until last) {
            val offset = j - first // use to calculate the flexible index
            val top = imgMatrix[first][j]

            // left -> top
            imgMatrix[first][j] = imgMatrix[last-offset][first]
            // bottom -> left
            imgMatrix[last-offset][first] = imgMatrix[last][last - offset]
            // right -> bottom
            imgMatrix[last][last - offset] = imgMatrix[j][last]
            // top -> right
            imgMatrix[j][last] = top
        }
    }
    


    println("****** After ******")
    for (i in imgMatrix.indices) {
        for (j in imgMatrix[i]) {
            print("$j ")
        }
        println("")
    }
}

// reset M * N matrix
// Big O: M * N + max(M,N) * max(M, N) ≈ M*N
fun resetMatrix(matrix: Array<Array<Int>>) {
    println("****** ResetMatrix ******")
    println("****** Before ******")
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            print("${matrix[i][j]} ")
        }
        println()
    }

    val len = max(matrix.size, matrix[0].size)
    val column = Array(len) {0}
    val row = Array(len) {0}
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] == 0) {
                column[j] = 1
                row[i] = 1
            }
        }
    }
    for (i in column.indices) {
        if (column[i] == 1) {
            for (k in 0 until len) {
                matrix[k][i] = 0
            }
        }

        if (row[i] == 1) {
            for (k in 0 until len) {
                matrix[i][k] = 0
            }
        }
    }

    println("****** After ******")
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            print("${matrix[i][j]} ")
        }
        println()
    }
}