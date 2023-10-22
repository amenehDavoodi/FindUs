//package com.example.findus.ui.utils
//
//import android.content.Context
//import android.location.LocationManager
//import androidx.core.content.ContextCompat.getSystemService
//import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
//import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay
//
//
//private fun isLocationEnabled(context:Context): Boolean {
//	val locationManager: LocationManager =
//		getSystemService(context,Context.LOCATION_SERVICE) as LocationManager
//	return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
//		LocationManager.NETWORK_PROVIDER
//	)
//}
//fun getCurrentLocation(context: Context){
//	MyLocationOverlay()
//	val mLocationOverlay = MyLocationNewOverlay(GpsMyLocationProvider(context), mMapView)
//	mLocationOverlay.enableMyLocation()
//	mMapView.getOverlays().add(this.mLocationOverlay)
//
//
//	/////////////////////////////////
//	mMyLocationOverlay = MyLocationOverlay(
//		this, mOsmv,
//		mResourceProxy
//	)
//	mMyLocationOverlay.disableMyLocation() // not on by default
//
//	mMyLocationOverlay.disableCompass()
//	mMyLocationOverlay.disableFollowLocation()
//	mMyLocationOverlay.setDrawAccuracyEnabled(true)
//	mMyLocationOverlay.runOnFirstFix(Runnable {
//		mOsmvController.animateTo(
//			mMyLocationOverlay
//				.getMyLocation()
//		)
//	})
//	mOsmOverlays.add(mMyLocationOverlay)
//}
//
