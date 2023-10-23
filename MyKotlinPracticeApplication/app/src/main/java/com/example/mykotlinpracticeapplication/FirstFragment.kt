package com.example.mykotlinpracticeapplication

import android.graphics.Color.rgb
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment


class FirstFragment : Fragment(R.layout.fragment_first) {
	override fun onCreate(savedInstanceState: Bundle?) {
		Log.d("lifeCycleFrg", "onCreate: ")
		super.onCreate(savedInstanceState)
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		Log.d("lifeCycleFrg", "onCreateView: ")
		return super.onCreateView(inflater, container, savedInstanceState)
	}
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		Log.d("lifeCycleFrg", "onViewCreated: ")
		super.onViewCreated(view, savedInstanceState)
		val red = requireArguments().getInt("red")
		val blue = requireArguments().getInt("blue")
		val green = requireArguments().getInt("green")
		view.findViewById<FrameLayout>(R.id.frLayout).setBackgroundColor(rgb(red, green, blue))
	}

	override fun onStart() {
		Log.d("lifeCycleFrg", "onStart: ")
		super.onStart()
	}

	override fun onResume() {
		Log.d("lifeCycleFrg", "onResume: ")
		super.onResume()
	}

	override fun onPause() {
		Log.d("lifeCycleFrg", "onPause: ")
		super.onPause()
	}

	override fun onStop() {
		Log.d("lifeCycleFrg", "onStop: ")
		super.onStop()
	}

	override fun onDestroyView() {
		Log.d("lifeCycleFrg", "onDestroyView: ")
		super.onDestroyView()
	}

	override fun onDestroy() {
		Log.d("lifeCycleFrg", "onDestroy: ")
		super.onDestroy()
	}

}