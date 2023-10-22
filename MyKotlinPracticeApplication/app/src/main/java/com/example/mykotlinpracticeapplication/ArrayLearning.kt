package com.example.mykotlinpracticeapplication

fun main() {

	val com = ArrayList<Int>()
	com.add(12)
	com.add(545)
	com.add(5)

	val list = mutableListOf<String>("s", "b", "a", "d")
	list.toList()

	val names =
		mutableListOf("Ameneh", "Tarane", "Taranom", "ABardia", "Toraj", "AMona", "Fateme")
	println(names)
	println(names.filter { name -> name.startsWith("T") })
	names.filter { name -> name.startsWith("A") }.map { it.lowercase() }
		.sortedDescending() .forEachIndexed {
			index,name->
			println("$index = $name")
		}
	println(names.joinToString(",", prefix = "{", postfix = "}"))


//	val nums = arrayOf("a", "b", "c", "c", "c", "c")
	val news= mutableListOf("ssss","dddd","aaaaa","ccccc")
	println(news)

	val setOfNews= mutableSetOf("sdfs",2,56,"ds","d","d",3)
	setOfNews.add("s")
	println(setOfNews)

	val listMap= mapOf(2 to "s",6 to "1",null to 23)
	listMap.forEach { (index, value) -> println("$index -> $value") }
//	println(news.mapNotNull { it as? Int })

	println("============================")
	Dad("Taranom","Asqari")
	println("============================")
	Dad("Taraneh","Asqari","Bardi")
	println("============================")
//	val shape=Shape("Ameneh","Davoodi")
	println(Shape22.NAME)
	println("***********************")
	School("aaaaaaaa").displayAge(34)
	println("***********************")
	userRole(Girl())
	println("***********************")
println(Person::class)
println(Person::class.java)

	try {
		Thread.sleep(100)
		throw Exception()
	}catch (e:InterruptedException){
		println("1")
	}catch (e:Exception){
		println("2")
	}


}

class Dad(val name:String, private var lastName:String): Person(name = name, age = 35)
{

	init {
		this.lastName=""
		println("Init First")

		val fullName="$name  $lastName"
		println(fullName)
	}
	constructor(name:String,lastName: String,dadName:String):this(name, lastName)
	{
		println("fullname : $name  $lastName  dad name is $dadName")
	}
	init {
		println("Init last")

		val fullname="$name  $lastName"
		println("Init $name  $lastName and fullname is : $fullname ")
	}

}
class Shape22 (val name: String, private var lname:String){
	private lateinit var test:JavaShape
	init {
		this.lname=""
	if (this::test.isInitialized){
		println("Test is initialized")
	}else {
		println("Test isn't initialized")
	}
		println("$name $lname")
	}

	companion object {
		const val NAME="ameneh"
	}
}

class School(private val address:String):Person(23,"")
{
	override fun displayAge(age: Int) {
		super.displayAge(age)
		println("in school class !! $address $age  $id")
	}
	fun displayAge(){
		println("display age in school")
	}
	fun displayAge(a:Int,name:String){
		println("display age in school")
	}
}
	fun userRole(
		any: Any
	){
		when (any){
			is Girl->"girl"
			is Boy->"boy"
			is Teacher->"teacher"
			is Doctor->"doctor"
			is Soccer->"soccer"
			is Person->"person"
		}
	}
