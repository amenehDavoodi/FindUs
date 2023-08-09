package com.example.mykotlinpracticeapplication

import kotlin.math.roundToInt


data class Computer(val name:String,val type:Int)

fun main() {
    val userNames= setOf("key1" to "ameneh",2 to "taranom",
        8 to "taraneh"
    )
    val numbers1= setOf(1,2,2,3)
    val numbers2= setOf(1,2,3,4)
    val numbers3= setOf(4,3,2,1)

    println("that sets are equal : numbers2.equals(numbers3) ${numbers2==numbers1}")

    val numberMap= mapOf("a" to 1,"b" to 2,4 to "ameneh",2.5 to "taraneh & taranom",9 to "bardia")
    val userMap= mutableMapOf("a" to 1,"b" to 2,4 to "ameneh",2.5 to "taraneh & taranom",9 to "bardia",12 to "jadid")
    userMap["a"] = 123
    userMap.putAll(numberMap)
    numbers1.forEach{
        i->
    userMap.putAll(mapOf(i to "dfsdf" ))
    }

    println("******************")
    println(userMap.keys)
    println(userMap.values)
    println("******************")

    for (i in numberMap)
        println(i)

    val list = mutableListOf("1", "2", "3")
    list.add("4")
    list.removeAt(0)
    for (i in list)
        println(i)

    for (i in userNames)
        println("value is : $i ")


    println("---------------------------")
    val h="Ameneh Davoodi"
    val h2=h.removeLastFirst()
    println(h2)

    val age =55.5
    val userAge=ageCalculate(age)
    println(userAge)
}


fun String.removeLastFirst():String=this.substring(1,this.length-1)
fun ageCalculate(age:Double): Int = age.roundToInt()