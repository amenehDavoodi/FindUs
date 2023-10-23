package com.example.findus.ui.presentation.home
import android.content.Context
import android.content.IntentSender
import androidx.activity.result.IntentSenderRequest
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationSettingsResponse
import com.google.android.gms.location.SettingsClient
import com.google.android.gms.tasks.Task

fun checkLocationSetting(
	context: Context,
	onDisabled: (IntentSenderRequest) -> Unit,
	onEnabled: () -> Unit
) {

	val locationRequest = LocationRequest.create().apply {
		interval = 1000
		fastestInterval = 1000
		priority = LocationRequest.PRIORITY_HIGH_ACCURACY
	}

	val client: SettingsClient = LocationServices.getSettingsClient(context)
	val builder: LocationSettingsRequest.Builder = LocationSettingsRequest
		.Builder()
		.addLocationRequest(locationRequest)

	val gpsSettingTask: Task<LocationSettingsResponse> =
		client.checkLocationSettings(builder.build())

	gpsSettingTask.addOnSuccessListener { onEnabled() }
	gpsSettingTask.addOnFailureListener { exception ->
		if (exception is ResolvableApiException) {
			try {
				val intentSenderRequest = IntentSenderRequest
					.Builder(exception.resolution)
					.build()
				onDisabled(intentSenderRequest)
			} catch (sendEx: IntentSender.SendIntentException) {
				// ignore here
			}
		}
	}

}