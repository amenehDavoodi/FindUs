package com.example.bookingmeetingroom.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection

private val DarkColorPalette = darkColors(
//    primary = Purple200,
    primaryVariant = Purple700,
//    secondary = Teal200
)

private val LightColorPalette = lightColors(
//    primary = Purple500,
    primaryVariant = Purple700,
//    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)
val LightThemeColors = lightColors(
    primary = Purple700,
    primaryVariant = Purple800,
    onPrimary = Color.White,
    secondary = Color.White,
    onSecondary = Color.Black,
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Red800,
    onError = Color.White
)

val DarkThemeColors = darkColors(
    primary = Purple300,
    primaryVariant = Purple600,
    onPrimary = Color.Black,
    secondary = Color.Black,
    onSecondary = Color.White,
    background = Color.Black,
    onBackground = Color.White,
    surface = Color.Black,
    onSurface = Color.White,
    error = Red300,
    onError = Color.Black
)

@Composable
fun BookingMeetingRoomTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        val colors = if (darkTheme) {
            DarkThemeColors
        } else {
            LightThemeColors
        }
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}