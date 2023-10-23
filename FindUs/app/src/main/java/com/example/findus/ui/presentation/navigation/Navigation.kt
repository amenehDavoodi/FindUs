package com.example.findus.ui.presentation.navigation

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController

class Navigation(
	private val navHostController: NavHostController
) {
	fun goToHome() = navHostController launch Route.Home

	fun goToSetting() = navHostController launch Route.Setting

	fun goToProfile() = navHostController launch Route.Profile
	fun goToLogin() = navHostController launch Route.Login
	fun goToIntro() = navHostController launch Route.Intro


}

private infix fun NavHostController.launch(navigationRoute: NavigationRoute) {
	navigate(route = navigationRoute.routeArg)
}
val LocalNavigation = compositionLocalOf<Navigation> { error("navigation") }