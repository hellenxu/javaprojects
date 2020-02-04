package main.java.com.six.kotlin

import kotlin.properties.Delegates

/**
 * @author hellenxu
 * @date 2019-12-09
 * Copyright 2019 Six. All rights reserved.
 */
fun main() {
    val user = User()

    /**
     * return value of let vs also
     * xxl-let: kotlin.Unit
     * xxl-also: User(id=87654321, name=test123)
     */

    val letReturnValue = user.let {
        it.id = "12345678"
        it.name = "test123"
    }
    println("xxl-let: $letReturnValue")

    val alsoReturnValue = user.also {
        it.id = "87654321"
        it.name = "test123"
    }
    println("xxl-also: $alsoReturnValue")

    // with
    with(user) {
        this.id = "0000"
        this.name = "test3"
    }
    println("xxl-with: $user")

    /**
     * return value of run vs apply
     * xxl-run: User(id=12333, name=test4)
     * xxl-run: kotlin.Unit
     * xxl-apply: User(id=88888, name=test5)
     * xxl-apply: User(id=88888, name=test5)
     */
    val runReturnValue = user.run {
        this.id = "12333"
        this.name = "test4"
    }

    println("xxl-run: $user")
    println("xxl-run: $runReturnValue")

    val applyReturnValue = user.apply {
        this.id = "88888"
        this.name = "test5"
    }

    println("xxl-apply: $user")
    println("xxl-apply: $applyReturnValue")

    val manager = AddressManager()
    val address = manager.man?.address ?: "null-address"
    println("xxl-man-street: $address")

    var vetoableInt: Int by Delegates.vetoable(0) { _, oldValue, newValue ->
        oldValue < newValue
    }

    println("vetoableInt = $vetoableInt")
    vetoableInt = 5
    println("vetoableInt = $vetoableInt")
    vetoableInt = 2
    println("vetoableInt = $vetoableInt")

    println("xxl-function literals with receiver - one: ${10.oneOrTwo { returnOne() }}")
    println("xxl-function literals with receiver - two: ${10.oneOrTwo { returnTwo() }}")
}

data class User(var id: String = "", var name: String = "")

data class Man(val id: String? = null, val address: Address? = null)


class FunctionContainer {
    fun returnOne(): Int {
        return 1
    }

    fun returnTwo(): Int {
        return 2
    }
}

fun Int.oneOrTwo(block: FunctionContainer.() -> Int): Int {
    FunctionContainer().also {
        return it.block()
    }
}