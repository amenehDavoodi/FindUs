package com.example.mykotlinpracticeapplication

abstract class User(name: String) {
    init {
        println("my name is : $name")
    }

    var id: Int = 0
    fun displayInfo() {
        println("user id is : $id")
    }

    abstract fun displayJob()
}

class Developer(name: String) : User(name) {
    override fun displayJob() {
        println("this is implemented in developer")
    }
}

fun main() {
    val dev = Developer("Amene")
//    dev.id = 12
    dev.displayInfo()
    dev.displayJob()
}