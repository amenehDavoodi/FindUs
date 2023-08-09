package com.example.mykotlinpracticeapplication
import com.example.mykotlinpracticeapplication.Menu.Companion.setTable

data class Personality(val name:String, val id:Int)
class Menu{
    companion object{
        var food:String=""
        fun setTable()= println("setting the table...\n and today food is \b $food")
    }
}

fun main(){
    val person1 = Personality("Amene", 1)
    val person2 = Personality("Tarane", 2)
    val person3 = Personality("Taranom", 3)
    val copyOf=person1.copy()
//    println(person1)
//    println(person2)
//    println(person3)
//    println(copyOf)
    val (name,id)=person3
    println(name)
    println(id)
    println(person2.component1())
    println(person2.component2())

    if (person1.hashCode() == person2.hashCode()){
        println("person 1 is equal with person2")
    }else{
        println("person 1 is not equal with person2")

    }
    if (person1 == copyOf){
        println("person 1 is equal with copy Of")
    }else{
        println("person 1 is not equal with copyOf")

    }

    Menu.food="sdfsdf"
    setTable()

}