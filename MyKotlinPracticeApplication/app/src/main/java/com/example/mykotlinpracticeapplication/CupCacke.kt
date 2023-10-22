package com.example.mykotlinpracticeapplication

import java.text.NumberFormat
import java.util.Locale

fun main() {
    val a = "  Ameneh Davoodi  "
    println(a.trim().trim('A', 'i', 'd', 'D').trimEnd())
    println(a.replace(" ", "o"))
    println(a.uppercase())
    println(a.lowercase())
    val nf = NumberFormat.getInstance(Locale("fa"))
//    nf.isParseIntegerOnly=true
    val number = 12322222
    println(nf.format(number))
    println(buildString {
        append(123)
        append("\n")
        append("dddd")
        append("\n")
        append("aaaaaa")

    })
    (1..5).forEach {
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
    println("---------------------")
    println("enter a : ")
//    val aa = readlnOrNull()?.toInt()

    println("enter b : ")
//    val b = readlnOrNull()?.toInt()
    val num1=12
    val num2=52
    val max1 = (num1>num2)?:num1 ?:num2


    /*    println("---------------------")

        when (aa) {
            in 1..18 -> println("کودک ")
            in 19 until 47 -> println("جوان ")
            in 47 until 67 -> println("میانسال ")
            in 67 until 97 -> println("کهنسال ")
            100 -> println("Dead!!")

        }*/
    /*   println(
           when (b) {
               in 1..18 -> {
                   println("کودک ")
                   "Taranom !! "
                   "Taraneh !! "
               }

               in 19 until 47 -> {
                   println("جوان ")
                   "Me !!"
               }

               in 67 until 97 -> println("کهنسال ")
               in 47 until 67 -> println("میانسال ")
               100 -> println("Dead!!")
               else-> println("Nothing!! ")

           }
       )*/

    println("---------------------")
    try {
//
//        val sca = Scanner(System.`in`)
//        val inter = sca.nextInt()
//        sca.close()
//        println(inter)
    } catch (e: Exception) {
        println("just enter number")
    }
    myLoop@
    for (i in 1..15)
        for (j in 0..3) {
            if (j == 2)
                break@myLoop
            println("i is : $i and j is $j")
        }

    println("*******************")

    val am: String? = null
    if (am != null) {
        println(am.length)
    }
    println("**********************")

    val al: String? = "null"
    println(al?.length)

    val min =am?.length.let {it->
        println(it)
    } ?: println("nothing")
    println("///////////////////")

    val w=PersonNew()
    w.info= Info()
    w.info?.name="ameneh"
    w.info?.let {
        info -> info.name="Taraneh"
        info.pass="sdhkfahsdkf"
    }
    println(w.id)
    println(w.info?.name)
    println(w.info?.pass)
}
 class PersonNew{
    val id:Int=0
     var info:Info? =null

}
class Info{
    var name:String=""
    var pass:String=""
}

