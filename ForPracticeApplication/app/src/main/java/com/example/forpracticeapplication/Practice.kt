package com.example.forpracticeapplication

import java.sql.DriverManager.println

fun main(){
    val names= arrayOf("a","b","c","d")
    for (i in names){
        println(i)
    }
    val testLambdaFun={ a:String, index:Int->
        for (i in 1..index){
            println(a)}
    }
    testLambdaFun("Taranom",5)
    val mobile=Mobile()
    println(mobile.turnOn)
    println(mobile.turnOff)
}
class Mobile{
    private val state:Boolean = false
    val turnOn= state
    val turnOff=  !state

}