package com.example.findus

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.findus.ui.presentation.home.HomeScreen
import com.example.findus.ui.presentation.navigation.Route

@Composable
fun MainGraph(
	navHostController: NavHostController
) {

	NavHost(navController = navHostController, startDestination = Route.Home.routeArg) {


		composable(route = Route.Intro.routeArg) {
		}
		composable(route = Route.Login.routeArg) {
		}
		composable(route = Route.Home.routeArg) {
			HomeScreen()
		}

		composable(route = Route.Profile.routeArg) {
		}

		composable(route = Route.Setting.routeArg) {
		}
	}
}


