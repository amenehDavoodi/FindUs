package com.example.findus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.findus.ui.presentation.home.LocationProviderChangedReceiver
import com.example.findus.ui.presentation.navigation.LocalNavigation
import com.example.findus.ui.presentation.navigation.Navigation
import com.example.findus.ui.theme.FindUsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//	private var homeViewModel: HomeViewModel= hiltViewModel()
	private var br: LocationProviderChangedReceiver? = null
	private var locationRequestLauncher: ActivityResultLauncher<IntentSenderRequest>? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {

			FindUsTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
//					val isLocationEnabled by homeViewModel.isLocationEnabled.collectAsState()
//					if (!isLocationEnabled) {
//						homeViewModel.enableLocationRequest(this@MainActivity) {//Call this if GPS is OFF.
//							locationRequestLauncher?.launch(it)//Launch it to show the prompt.
//						}
//					}
					val navHostController = rememberNavController()

					val navigation = remember {
						Navigation(navHostController)
					}

						CompositionLocalProvider(LocalNavigation provides navigation) {
							MainGraph(navHostController = navHostController)

					}

				}
			}
		}

	}
//	private fun registerLocationRequestLauncher() {
//		locationRequestLauncher =//We will create a global var
//			registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { activityResult ->
//				if (activityResult.resultCode == RESULT_OK) {
////					mapsViewModel.updateCurrentLocationData(this)//If the user clicks OK to turn on location
//					Toast.makeText(
//						this,
//						"Turn on location \n access current location ",
//						Toast.LENGTH_LONG
//					)
//						.show()
//				}
//				else {
//					if (!homeViewModel.isLocationEnabled.value) {//If the user cancels, Still make a check and then exit the activity
//						Toast.makeText(
//							this,
//							"Location access is mandatory to use this feature!!",
//							Toast.LENGTH_SHORT
//						)
//							.show()
//						finish()
//					}
//				}
//			}
//	}
//	private fun registerBroadcastReceiver() {
//		br = LocationProviderChangedReceiver()
//		br!!.init(
//			object : LocationProviderChangedReceiver.LocationListener {
//				override fun onEnabled() {
//					homeViewModel.isLocationEnabled.value = true//Update our VM
//				}
//
//				override fun onDisabled() {
//					homeViewModel.isLocationEnabled.value = false//Update our VM
//				}
//			}
//		)
//		val filter = IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION)
//		registerReceiver(br, filter)
//	}

	override fun onDestroy() {
		super.onDestroy()
		if (br != null) unregisterReceiver(br)
	}
}


