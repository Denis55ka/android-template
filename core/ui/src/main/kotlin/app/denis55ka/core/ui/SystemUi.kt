package app.denis55ka.core.ui

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SystemUi(
    block: SystemUiController.(Colors) -> Unit
) {
    val systemUiController = rememberSystemUiController()
    val colors = MaterialTheme.colors
    DisposableEffect(Unit) {
        systemUiController.block(colors)
        onDispose {
            systemUiController.systemBarsDarkContentEnabled = colors.isLight
        }
    }
}
