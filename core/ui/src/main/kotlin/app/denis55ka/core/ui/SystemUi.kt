package app.denis55ka.core.ui

import android.content.Context
import android.graphics.Color
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import app.denis55ka.core.ui.extensions.requireActivity

@Composable
fun SystemUi(
    context: Context = LocalContext.current,
    statusBarStyle: SystemBarStyle = remember { SystemBarStyle.auto(Color.TRANSPARENT, Color.TRANSPARENT) },
    navigationBarStyle: SystemBarStyle = remember { SystemBarStyle.auto(DefaultLightScrim, DefaultDarkScrim) },
) {
    DisposableEffect(Unit) {
        val activity = context.requireActivity()
        activity.enableEdgeToEdge(statusBarStyle, navigationBarStyle)
        onDispose(activity::enableEdgeToEdge)
    }
}

private val DefaultLightScrim = Color.argb(0xe6, 0xFF, 0xFF, 0xFF)
private val DefaultDarkScrim = Color.argb(0x80, 0x1b, 0x1b, 0x1b)
