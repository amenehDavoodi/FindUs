package com.example.mykotlinpracticeapplication.oop

class Square(
	private val side: Int
) : Rectangle(side, side), Clonable<Rectangle> {
	override fun draw() {
		println("square")
	}

	override fun clone(): Rectangle {
		return Rectangle(width, height, color, label)
	}

	override fun around() = 4 * side

	override fun equals(other: Any?): Boolean {
		return super.equals(other)
	}

	override fun hashCode(): Int {
		return super.hashCode()
	}

	override fun toString(): String {
		return super.toString()
	}
}

fun main() {
	val square = Square(5)
	val square2 = Square(5)
	square.clone()
	println(square.area())
	println(square.around())
	square.draw()

	println(square2.area())
	println(square2.around())
	square2.draw()
	square2.clone()
	println(square.isSquare())
	println(square2.isSquare())
	println("////////////////")
	val myName: String = "asdasd"

	println(myName.let {
		it.length
		it.uppercase()
		it.compareTo("sss")

	})
	println("////////////////")
	val myList= listOf(1,2,5,6,7)
	myList.run {

	}


//	println((square === square2))
//	println((square2 == square))
}