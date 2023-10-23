package com.example.mykotlinpracticeapplication

interface A {
    var id: Int
    fun getUserName(name: String) {
        println("show my name :$name")
    }

    fun showUserName()
}

interface B {
    fun getAllNum(): Int
}

class UserNew() : A, B {
    override var id: Int = 12
    override fun showUserName() {
        println("user name is displayed !!")
    }

    override fun getAllNum(): Int {
        println("user is good")
        return 1
    }

}

fun main() {
    val user = UserNew()
    user.getUserName("tarane")
    user.getAllNum()
    user.showUserName()
}