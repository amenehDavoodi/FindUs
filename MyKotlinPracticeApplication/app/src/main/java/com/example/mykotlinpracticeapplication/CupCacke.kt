package com.example.mykotlinpracticeapplication

import java.text.NumberFormat
import java.util.Locale

fun main (){
    val a="  Ameneh Davoodi  "
    println(a.trim().trim('A','i','d','D').trimEnd())
    println(a.replace(" ","o"))
    println(a.uppercase())
    println(a.lowercase())
    val nf=NumberFormat.getInstance(Locale("fa"))
//    nf.isParseIntegerOnly=true
    val number=12322222
    println(nf.format(number))
    println(buildString {
        append(123)
        append("\n")
        append("dddd")
        append("\n")
        append("aaaaaa")

    })
    (1 .. 5 ).forEach{
        println(it)
    }
    println("---------------------")
    (2 until 10 step 2).forEach {

        println(it)
//        }
    }
    println("---------------------")
    
    (15 downTo 5 step 3).forEach {
        println(it)
    }

}