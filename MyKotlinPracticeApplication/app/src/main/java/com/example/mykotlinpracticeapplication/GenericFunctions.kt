package com.example.mykotlinpracticeapplication

class PersonUser<T>(input:T){init {
    println("the type is $input")
}
    fun <T>calculate(input: T)
    {
        println(input)

    }

}
fun main(){
    PersonUser("Taraneh").calculate("ameneh")
    PersonUser(2).calculate(500)
}