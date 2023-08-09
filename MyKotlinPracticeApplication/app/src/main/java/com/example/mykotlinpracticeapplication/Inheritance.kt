package com.example.mykotlinpracticeapplication

open class Person(age: Int, name: String) {
   open var id:Int =0
    open fun displayAge(age: Int) {
        println("My age is : $age")
    }

    init {
        println("My name is : $name")
        println("My age is : $age")
    }
}

class Girl() : Person(12, "") {

    override var id: Int = 15
        get() = super.id
        set(value) {
            field=value-5
        }

    override fun displayAge(age: Int) {
        println("My New age : ${age - 5}")
    }
}

class Teacher(age: Int, name: String) : Person(age, name) {
    fun teaching() {
        println("I'm a teacher ...")
    }
}

class Doctor(age: Int, name: String) : Person(age, name) {
    fun caring() {
        println("I'm a doctor ...")
    }
}

class Soccer(age: Int, name: String, country: String) : Person(age, name) {
    init {
        println("My country is : $country")
    }

    fun playing() {
        println("I play football ...")
    }
}

fun main() {
    Teacher(32, "Goli").teaching()

    println("----------------------------")

    Doctor(33, "Tarane").caring()
    println("----------------------------")


    val soccer = Soccer(15, "Hadi", "Iran")
    soccer.playing()

    println("----------------------------")

    Autho("Error", 10)
    println("----------------------------")

    val girl=Girl()
    println("person Id is : ${girl.id}")
    println("person Id is : ${girl.displayAge(12)}")

}

open class Log {
    var data: String = ""
    var numberOfData = 0

    constructor(_data: String) {}
    constructor(_data: String, _numberOfData: Int) {
        data = _data
        numberOfData = _numberOfData
        println("data : $data And number Of Data is : $numberOfData")
    }
}

class Autho//    constructor(_data: String):this("From Autho $_data",10)
//    {
//
//    }
    (_data: String, _numberOfData: Int) : Log(_data, _numberOfData) {
}
