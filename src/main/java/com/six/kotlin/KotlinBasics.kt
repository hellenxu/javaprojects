package main.java.com.six.kotlin

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

}

data class User(var id: String = "", var name: String = "")
