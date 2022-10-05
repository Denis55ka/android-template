package app.deni55ka.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

object Themes {

    @Composable
    fun Main(
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit
    ) {
        MaterialTheme(
            colors = if (darkTheme) Colors.Dark else Colors.Light,
            typography = Typographies.Default,
            shapes = Shapes.Default,
            content = content
        )
    }
}
