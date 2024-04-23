package app.denis55ka.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object Themes {

    @Composable
    fun Main(
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit
    ) {
        MaterialTheme(
            colorScheme = if (darkTheme) DarkColors else LightColors,
            shapes = Shapes,
            content = content
        )
    }
}

private val DarkColors = darkColorScheme(
    primary = Color(0xFFFF9800),
    background = Color.Black,
    surface = Color(0xFF16181C),
)

private val LightColors = lightColorScheme(
    primary = Color(0xFFFF9800),
    background = Color.White,
    surface = Color.White,
)

private val Shapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp),
)
