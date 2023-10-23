package com.example.mykotlinpracticeapplication

class Galaxy{
    private val base=12
    val p=3.14

    inner class Sun{
        private val size=100
        fun area()= size*p
    }
}
fun main(){
    val galaxy=Galaxy().Sun().area()
    println(galaxy)
}