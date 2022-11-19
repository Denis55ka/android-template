package app.denis55ka.feature1.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import app.denis55ka.core.navigation.DeepLinkHost
import app.denis55ka.core.navigation.LocalNavController
import app.denis55ka.core.navigation.Screen
import app.denis55ka.core.navigation.extension.navigate
import app.denis55ka.core.ui.SystemUiController
import app.denis55ka.core.ui.viewmodel.userViewModel
import app.denis55ka.feature3.ui.Feature3Screen
import app.denis55ka.main.ui.MainScreen
import app.denis55ka.main.ui.MainTab

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Feature1Screen() {
    SystemUiController { statusBarDarkContentEnabled = false }
    val viewModel: Feature1ViewModel = userViewModel()
    BackdropScaffold(
        modifier = Modifier.statusBarsPadding(),
        appBar = { /* TODO */ },
        backLayerBackgroundColor = Color.Black,
        backLayerContent = { /* TODO */ },
        frontLayerShape = MaterialTheme.shapes.large.copy(bottomStart = ZeroCornerSize, bottomEnd = ZeroCornerSize),
        frontLayerScrimColor = Color.Unspecified,
        frontLayerContent = {
            Column(
                Modifier.fillMaxSize(),
                Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                Alignment.CenterHorizontally
            ) {
                Text("Feature 1")
                NavigateButton(MainScreen(MainTab.FEATURE2))
                NavigateButton(Feature3Screen)
                DeepLinkButton((DeepLinkHost + MainScreen(MainTab.FEATURE2).route).toUri())
                DeepLinkButton(Feature3Screen.deepLinks.first().toUri())
            }
        }
    )
}

@Composable
private fun NavigateButton(screen: Screen) {
    val navController = LocalNavController.current
    Button(onClick = {
        navController.navigate(screen)
    }) {
        Text(screen.route)
    }
}

@Composable
private fun DeepLinkButton(uri: Uri) {
    val context = LocalContext.current
    TextButton(onClick = {
        context.startActivity(Intent(Intent.ACTION_VIEW, uri))
    }) {
        Text(uri.toString())
    }
}
