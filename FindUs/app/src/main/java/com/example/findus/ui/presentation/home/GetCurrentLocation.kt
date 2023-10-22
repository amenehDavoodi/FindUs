package com.example.findus.ui.presentation.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices
import org.osmdroid.util.GeoPoint

@Composable
fun LocationScreen() {
	val context = LocalContext.current
	var location by remember { mutableStateOf("Your location") }
	val userCurrentLocation = GeoPoint(0, 0)
	// Create a permission launcher
	val requestPermissionLauncher =
		rememberLauncherForActivityResult(
			contract = ActivityResultContracts.RequestPermission(),
			onResult = { isGranted: Boolean ->
				if (isGranted) {
					// Permission granted, update the location
					getCurrentLocation(context) { lat, long ->
						userCurrentLocation.latitude = lat
						userCurrentLocation.longitude = long
						location = "Latitude: $lat,\n" +
								" Longitude: $long"
					}
				}
			})



	if (hasLocationPermission(context)) {
		// Permission already granted, update the location
		getCurrentLocation(context) { lat, long ->
			userCurrentLocation.latitude = lat
			userCurrentLocation.longitude = long
			location = "Latitude: $lat,\n Longitude: $long"
		}
	} else {
		// Request location permission
		SideEffect {
			requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
		}
	}


}


fun hasLocationPermission(context: Context): Boolean {
	return (ActivityCompat.checkSelfPermission(
		context,
		Manifest.permission.ACCESS_FINE_LOCATION
	) == PackageManager.PERMISSION_GRANTED
			)
}

fun getCurrentLocation(context: Context, callback: (Double, Double) -> Unit) {
	val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
	if (ActivityCompat.checkSelfPermission(
			context,
			Manifest.permission.ACCESS_FINE_LOCATION
		) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
			context,
			Manifest.permission.ACCESS_COARSE_LOCATION
		) != PackageManager.PERMISSION_GRANTED
	) {
		return
	} else {
		fusedLocationClient.lastLocation
			.addOnSuccessListener { location ->
				if (location != null) {
					val lat = location.latitude
					val long = location.longitude
					callback(lat, long)
				}
			}
			.addOnFailureListener { exception ->
				// Handle location retrieval failure
				exception.printStackTrace()
			}
	}

}




