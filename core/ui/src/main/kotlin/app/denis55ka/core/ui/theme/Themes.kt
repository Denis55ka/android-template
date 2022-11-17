package app.denis55ka.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalElevationOverlay
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object Themes {

    @Composable
    fun Main(
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit
    ) {
        CompositionLocalProvider(
            LocalElevationOverlay provides null
        ) {
            MaterialTheme(
                colors = if (darkTheme) DarkColors else LightColors,
                shapes = Shapes,
                content = content
            )
        }
    }
}

private val DarkColors = darkColors(
    primary = Color(0xFFFF9800),
    background = Color.Black,
    surface = Color(0xFF16181C),
)

private val LightColors = lightColors(
    primary = Color(0xFFFF9800),
    background = Color.White,
    surface = Color.White,
)

private val Shapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp),
)
