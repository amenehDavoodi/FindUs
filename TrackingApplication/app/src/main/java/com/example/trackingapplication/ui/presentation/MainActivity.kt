package com.example.trackingapplication.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trackingapplication.ui.presentation.home.HomeScreen
import com.example.trackingapplication.ui.presentation.navaigation.Screen
import com.example.trackingapplication.ui.theme.TrackingApplicationTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
//		Configuration.getInstance().load(
//			applicationContext,
//			PreferenceManager.getDefaultSharedPreferences(applicationContext)
//		)
		setContent {
			MaterialTheme{
//				TrackingApplicationTheme {
					// A surface container using the 'background' color from the theme
					Surface(
						modifier = Modifier.fillMaxSize(),
						color = MaterialTheme.colorScheme.background
					) {
						val navController = rememberNavController()
						NavHost(
							navController = navController,
							startDestination = Screen.HomeScreen.route
						) {

							composable(route = Screen.HomeScreen.route) {
								HomeScreen(navController = navController)
							}
						}
					}
//				}
			}

		}
	}
}




