package com.example.testapplication

import java.sql.DriverManager.println

fun main() {
    printSum(12, 50)
}

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}
