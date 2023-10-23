package com.example.mykotlinpracticeapplication.oop

abstract class Shape(
	var color:Int,
	protected var label:String
):Drawable {
	abstract fun area():Int
	abstract fun around():Int

}