package com.example.mykotlinpracticeapplication.oop

data class Ensan(
	val name: String,
	val lname: String,
	val birthDate: String?
)

enum class Category {
	News,
	Article,
	Game,
	Novel,
	Paint
}

enum class Color(val code: Int) {
	Red(0x00ff00),
	Green(0x00ff00),
	Blue(0x00ff00);

	fun getColorCode(): Int {
		return when (this) {
			Red -> 0x00ff00
			Green -> 0x00ff00
			Blue -> 0x00ff00
		}
	}
}

fun getColor(color: Color): String {
	color.getColorCode()
	return when (color) {
		Color.Red -> "red"
		Color.Green -> "green"
		Color.Blue -> "blue"
	}
}

fun main() {
	val p1 = Ensan("Ameneh", "sd", "123123")
	val p2 = Ensan("Ameneh", "we", "4535")
	println(p1 === p2)
	println(p1 == p2)
	val (name, lastname, birth) = p1
	println(name)
	println(lastname)
	println(birth)
	val (_, lname, _) = Ensan("Bardia", "Asqari", "234234")
	println(lname)
	enumValues<Category>().forEach {
		println("$it -> ${it.ordinal}")
	}
	when (val result = getResult()) {
		is Result.Error -> println("Error : ${result.error}")
		is Result.Loading -> println("Loading : ${result.tag}")
		is Result.Success -> println("Success : ${result.data}")
	}

	val sq: (Int, String) -> Int = { index, value ->
		println("This is $index , and this is $value")
		3
	}
	sq(10,"ameneh")

	object :Drawable{
		override fun draw() {
			println("Drawn")
		}
	}

	println("**********")
	val shape=Rectangle(5,6)
	val shape1=Rectangle(6,6)
	val shape2=Rectangle(16,54)
	println(shape.isSquare())
	println(shape1.isSquare())
	println(shape2.isSquare())

}

sealed class Result<T> {

	data class Success<T>(val data: T) : Result<T>()
	class Error<T>(val error: Any) : Result<T>()
	class Loading<T>(val tag: Any) : Result<T>()

}

fun getResult(): Result<String> = Result.Success("safas").also {
	println("in alsoooooooooo")
}

//extension func
fun Rectangle.isSquare():Boolean{
	return width==height
}



