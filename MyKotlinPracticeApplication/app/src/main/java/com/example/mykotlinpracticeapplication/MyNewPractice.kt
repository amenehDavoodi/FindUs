package com.example.mykotlinpracticeapplication

class PersonOne {
    var name:String="Default"
        get() = field
        set(value) {
            field=value
        }
}
class Boy{
    var actualAge:Int=34
    var age:Int =9
        get() = field
        set(value) {
          field=when{
              value> 18 ->18
              value in 1..18 ->value
              else-> value -2
          }
        }
}
fun main(){
    val person=PersonOne()
    person.name="Amene"
    println( person.name)
    println("--------------------------------")
    val bardi=Boy()
    bardi.age=31
    bardi.actualAge=36
    println("Bardia age is : ${bardi.age}")
    println("Bardia Actual age is : ${bardi.actualAge}")
    }