package com.example.findus.ui.presentation.navigation


sealed class Screen(val route: String) {
	object HomeScreen: Screen("home_screen")
	object LoginScreen: Screen("login_screen")
	object SplashScreen: Screen("splash_screen")
}