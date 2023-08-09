package com.example.myapplication

fun main(){
    val myList= arrayOf("a","b","c","a","s","b","s")
    val i=9
    loops(myList)
    drawLine()
    println(user("Tarane","Asqari"))
    drawLine()
    lambda()
    drawLine()
    val mobile=Mobile()
    mobile.turnOf()
    mobile.showState()
//    for (i in 0..myList.size)
//    {
//        println(selectUniques(myList))
//    }
}
fun selectUniques(listAll:Array<String>):Array<String>{
    var uniqueList = Array(listAll.size){
        i->listAll[0]
    }
    for (i in listAll.indices){
        if (i==0){
            uniqueList.set(0,listAll[i])
        }else{
            for (j in uniqueList.indices)
                if (listAll[i]!= uniqueList[j])
                    uniqueList[j+1] = listAll[i]
        }

    }


        return uniqueList
}
fun loops(listAll:Array<String>){
    var t=0
    do {
        println(t)
        t++

    }while (t <= 8)
    println("t is bigger than 8\n --------------------------------------------")

    for (b in listAll){
        println(b)
    }

    println("-------------------------------------------------------------")

    for (b in listAll.indices){
        println("$b is index of ${listAll[b]}")
    }
}
fun user(name:String,lastName:String):String{
    return "user is : $name  $lastName"
}
fun drawLine(){
    println("-------------------------------------------------------------")

}
fun lambda(){
    val ave={a:Double,b:Double -> (a+b)/2}
    println(ave(5.0,10.0))

}
open class Mobile()
{
    private var state:Boolean=false
    fun turnOf() { state=false }
    fun turnOn(){
        state=true
    }
    open fun showState(){
      println(state)
    }
}