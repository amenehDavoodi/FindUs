package com.example.mykotlinpracticeapplication.oop

open class Rectangle(
	val width:Int,
	val height:Int,
	color:Int=0,
	label:String="rectangle"

):Shape(color,label) {
	override fun area()=width*height

	override fun draw() {
		println("Rectangle ")
	}

	override fun around()=2*(width+height)
}