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

    val head = prepareLinkedList()
    removeDupsWithLinkedList(head)

    getSubListWithLinkedList(3, head)
}

private fun prepareLinkedList(): LinkedListNode {
    val head = LinkedListNode(null, 10)
    var current = head
    for (i in 0..15) {
        val tmp = LinkedListNode(null, i % 7)
        current.next = tmp
        current = tmp
    }

    return head
}

fun removeDups(input: MutableList<Any?>) {
    println("****** Before ******")
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

class LinkedListNode(var next: LinkedListNode?, val data: Int)

// Big O: N [N == length of LinkedList]
fun removeDupsWithLinkedList(head: LinkedListNode?) {
    println("****** Before ******")
    iterateLinkedList(head)

    val tmp = arrayListOf<Int>()
    var previous: LinkedListNode? = null
    var current: LinkedListNode? = head

    while (current != null) {
        if (tmp.contains(current.data)) {
            previous?.next = current.next
        } else {
            tmp.add(current.data)
            previous = current
        }

        current = current.next
    }


    println("****** After ******")
    iterateLinkedList(head)
}

// Big O: N
fun getSubListWithLinkedList(target: Int, head: LinkedListNode?) {

    println("****** Whole LinkedList ******")
    iterateLinkedList(head)

    var count = 1
    var currentNode = head
    var targetNode: LinkedListNode? = null

    while (currentNode != null) {
        if (count == target) {
            targetNode = currentNode
            break
        } else {
            count ++
        }
        currentNode = currentNode.next
    }

    println("****** Sub LinkedList ******")

    iterateLinkedList(targetNode)
}

private fun iterateLinkedList(head: LinkedListNode?) {
    if (head == null) {
        throw Exception("it's an empty list")
    }

    var readCurrent = head
    while (readCurrent != null) {
        val output: String = if (readCurrent != head) {
            " -> ${readCurrent.data}"
        } else {
            "${readCurrent.data}"
        }
        print(output)
        readCurrent = readCurrent.next
    }
    println()
}