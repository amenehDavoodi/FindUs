package com.example.trackingapplication.ui.presentation.navaigation

sealed class Screen(val route: String) {
	object HomeScreen: Screen("home_screen")
}
