package com.example.findus.ui.presentation.home

import android.Manifest
import android.app.Activity
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.MutableLiveData
import com.example.findus.R
import com.utsman.osmandcompose.DefaultMapProperties
import com.utsman.osmandcompose.Marker
import com.utsman.osmandcompose.OpenStreetMap
import com.utsman.osmandcompose.ZoomButtonVisibility
import com.utsman.osmandcompose.rememberCameraState
import com.utsman.osmandcompose.rememberMapViewWithLifecycle
import com.utsman.osmandcompose.rememberMarkerState
import com.utsman.osmandcompose.rememberOverlayManagerState
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.CopyrightOverlay
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

val mashhad = GeoPoint(36.2972, 59.6067)

var lati =MutableLiveData(36.2972)
var longi = MutableLiveData(59.6067)

@Composable
fun HomeScreen(
	homeViewModel: HomeViewModel = hiltViewModel()
) {
	MapScreen()
}


@Composable
fun MapScreen(homeViewModel: HomeViewModel = hiltViewModel()) {

	val context = LocalContext.current

	val settingResultRequest = rememberLauncherForActivityResult(
		contract = ActivityResultContracts.StartIntentSenderForResult()
	) { activityResult ->
		if (activityResult.resultCode == Activity.RESULT_OK)
			Log.d("appDebug", "Accepted")
		else {
			Log.d("appDebug", "Denied")
		}
	}
	checkLocationSetting(
		context = context,
		onDisabled = { intentSenderRequest ->
			settingResultRequest.launch(intentSenderRequest)
		},
		onEnabled = {
			getCurrentLocation(context) { lat, long ->
				lati.value=lat
				longi.value= long

			}

		}
	)
	val cameraState = rememberCameraState {
		geoPoint = GeoPoint(lati.value!!,longi.value!!)
		zoom = 14.0
	}

	val userMarkerState = rememberMarkerState(
		geoPoint = GeoPoint(lati.value!!,longi.value!!),
		rotation = 90f
	)

	var mapProperties by remember {
		mutableStateOf(DefaultMapProperties)
	}
	val overlayManagerState = rememberOverlayManagerState()
	val userIcon: Drawable? by remember {
		mutableStateOf(context.getDrawable(R.drawable.placeholder))
	}


	val requestPermissionLauncher =
		rememberLauncherForActivityResult(
			contract = ActivityResultContracts.RequestPermission(),
			onResult = { isGranted: Boolean ->
				if (isGranted) {
					// Permission granted, update the location
					getCurrentLocation(context) { lat, long ->
						lati.value=lat
						longi.value=long

					}
				}
			})

	if (hasLocationPermission(context)) {
		// Permission already granted, update the location
		getCurrentLocation(context) { lat, long ->
			lati.value=lat
			longi.value=long
		}
	} else {
		SideEffect{

		requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
		}
		getCurrentLocation(context) { lat, long ->
			lati.value=lat
			longi.value=long
		}
		// Request location permission
	}

	SideEffect {
		mapProperties = mapProperties
			.copy(isTilesScaledToDpi = true)
			.copy(tileSources = TileSourceFactory.MAPNIK)
			.copy(isEnableRotationGesture = true)
			.copy(zoomButtonVisibility = ZoomButtonVisibility.ALWAYS)
	}

	OpenStreetMap(
		modifier = Modifier.fillMaxSize(),
		cameraState = cameraState,
		properties = mapProperties,
		overlayManagerState = overlayManagerState,
		onFirstLoadListener = {
			getCurrentLocation(context, callback = { lat, long ->
				lati.value = lat
				longi.value= long

			})
			val copyright = CopyrightOverlay(context)
			overlayManagerState.overlayManager.add(copyright)
		},
		onMapClick = {

		}
	) {
		Marker(
			state = userMarkerState,
			icon = userIcon,
			title = "Me!!",
			snippet = "Ameneh Davoodi"
		) {
			Column(
				modifier = Modifier
					.size(100.dp)
					.background(color = Color.LightGray, shape = RoundedCornerShape(7.dp)),
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Text(text = it.title)
				Text(text = it.snippet, fontSize = 10.sp)
			}
		}
		val map = rememberMapViewWithLifecycle()
		val mMyLocationOverlay =
			MyLocationNewOverlay(GpsMyLocationProvider(context), map)
		val mapController = map.controller
		mMyLocationOverlay.enableMyLocation()
		mMyLocationOverlay.disableFollowLocation()
		mMyLocationOverlay.isDrawAccuracyEnabled = true
		mMyLocationOverlay.runOnFirstFix {
			run {
				mapController.animateTo(GeoPoint(lati.value!!, longi.value!!))
				mapController.setZoom(18)
			}
		}
		map.overlays.add(mMyLocationOverlay)


	}


}
