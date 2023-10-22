package com.example.mykotlinpracticeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		Log.d("lifeCycle", "onCreate: ")
		if (savedInstanceState == null) {
			findViewById<Button>(R.id.button3).setOnClickListener {
				goToFirstFrg()
			}
			findViewById<Button>(R.id.button4).setOnClickListener {
				goToSecondFrg()
			}
		}


	}

	private fun goToFirstFrg() {
		val bundle = Bundle()
		bundle.putInt("red", (0..255).random())
		bundle.putInt("blue", (0..255).random())
		bundle.putInt("green", (0..255).random())

		supportFragmentManager.beginTransaction()
			.replace<FirstFragment>(R.id.fragment_container_view_tag,args=bundle)
			.addToBackStack("first")
			.setReorderingAllowed(true)
			.commit()
	}

	private fun goToSecondFrg() {
		supportFragmentManager.beginTransaction()
			.replace(R.id.fragment_container_view_tag, SecondFragment())
			.addToBackStack("second")
			.commit()
	}

	override fun onStart() {
		super.onStart()
		Log.d("lifeCycle", "onStart: ")
	}

	override fun onResume() {
		super.onResume()
		Log.d("lifeCycle", "onResume: ")
	}

	override fun onRestart() {
		super.onRestart()
		Log.d("lifeCycle", "onRestart: ")
	}

	override fun onPause() {
		super.onPause()
		Log.d("lifeCycle", "onPause: ")
	}

	override fun onStop() {
		super.onStop()
		Log.d("lifeCycle", "onStop: ")
	}

	override fun onDestroy() {
		super.onDestroy()
		Log.d("lifeCycle", "onDestroy: ")
	}
}