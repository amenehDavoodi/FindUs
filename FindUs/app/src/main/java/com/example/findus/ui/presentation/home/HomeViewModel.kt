package com.example.findus.ui.presentation.home

import android.Manifest
import android.content.Context
import android.content.IntentSender
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationSettingsResponse
import com.google.android.gms.location.Priority
import com.google.android.gms.location.SettingsClient
import com.google.android.gms.tasks.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.osmdroid.util.GeoPoint
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
	private val locationHelper: LocationHelper
) : ViewModel(){
	val isLocationEnabled = MutableStateFlow(false)
	val myCurrentLocation = MutableStateFlow(GeoPoint(36.2972, 59.6067))

	init {
		updateLocationServiceStatus()
	}
	private fun updateLocationServiceStatus() {
		isLocationEnabled.value = locationHelper.isConnected()
	}
@Composable
	fun getCurrentLocation(context: Context){
		val requestPermissionLauncher =
			rememberLauncherForActivityResult(
				contract = ActivityResultContracts.RequestPermission(),
				onResult = { isGranted: Boolean ->
					if (isGranted) {
						// Permission granted, update the location
						getCurrentLocation(context) { lat, long ->
						myCurrentLocation.value.latitude=lat
						myCurrentLocation.value.longitude=long

						}
					}
				})



		if (hasLocationPermission(context)) {
			// Permission already granted, update the location
			getCurrentLocation(context) { lat, long ->
				myCurrentLocation.value.latitude=lat
				myCurrentLocation.value.longitude=long
			}
		} else {
			// Request location permission
			requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
		}
	}



	fun enableLocationRequest(
		context: Context,
		makeRequest: (intentSenderRequest: IntentSenderRequest) -> Unit//Lambda to call when locations are off.
	) {
		val locationRequest = LocationRequest.Builder(//Create a location request object
			Priority.PRIORITY_HIGH_ACCURACY,//Self explanatory
			10000//Interval -> shorter the interval more frequent location updates
		).build()

		val builder = LocationSettingsRequest.Builder()
			.addLocationRequest(locationRequest)

		val client: SettingsClient = LocationServices.getSettingsClient(context)
		val task: Task<LocationSettingsResponse> = client.checkLocationSettings(builder.build())//Checksettings with building a request
		task.addOnSuccessListener { locationSettingsResponse ->
			Log.d(
				"Location",
				"enableLocationRequest: LocationService Already Enabled"
			)
		}
		task.addOnFailureListener { exception ->
			if (exception is ResolvableApiException) {
				// Location settings are not satisfied, but this can be fixed
				// by showing the user a dialog.
				try {
					val intentSenderRequest =
						IntentSenderRequest.Builder(exception.resolution).build()//Create the request prompt
					makeRequest(intentSenderRequest)//Make the request from UI
				} catch (sendEx: IntentSender.SendIntentException) {
					// Ignore the error.
				}
			}
		}
	}



}
