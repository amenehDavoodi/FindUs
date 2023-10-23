package com.example.trackingapplication.ui.presentation.home

import android.content.Context
import android.util.Xml
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.trackingapplication.R
import org.neshan.mapsdk.MapView


@Composable
fun HomeScreen(
	navController: NavController
) {
	val context = LocalContext.current
	CustomMapView(context)

}



@Composable
fun CustomMapView(context: Context) {
	val parser=context.resources.getXml(R.xml.attrs)
	val attrs = Xml.asAttributeSet(parser)
	val maping =  context.resources.getLayout(R.layout.layout_map)

	Box(
		contentAlignment = Alignment.Center,
		modifier = Modifier
			.background(MaterialTheme.colorScheme.background)
			.fillMaxSize()
	) {
		AndroidView(
			modifier = Modifier,
			factory = { context ->

				MapView(context, attrs).getViewById(R.id.map).apply  {
					R.id.map
				}
			}, update = {})
	}


}







