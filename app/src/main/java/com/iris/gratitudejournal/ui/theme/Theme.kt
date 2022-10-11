package com.iris.gratitudejournal.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightColorPalette = lightColors(
    primary = Navy,
    secondary = Blue,
    background = BlueGray
)

@Composable
fun GratitudeJournalTheme(content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setNavigationBarColor(
            color = LightColorPalette.background,
            darkIcons = true
        )
        systemUiController.setStatusBarColor(
            color = LightColorPalette.background,
            darkIcons = true
        )
    }
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}