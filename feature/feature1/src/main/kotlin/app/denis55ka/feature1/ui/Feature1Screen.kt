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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import app.denis55ka.core.navigation.DeeplinkFactory
import app.denis55ka.core.ui.SystemUi
import app.denis55ka.core.ui.viewmodel.applicationViewModel
import app.denis55ka.feature2.ui.Feature2Screen
import app.denis55ka.feature3.ui.Feature3Screen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Feature1Screen(onNavigateFeature2: () -> Unit, onNavigateFeature3: () -> Unit) {
    SystemUi { statusBarDarkContentEnabled = false }
    @Suppress("UNUSED_VARIABLE")
    val viewModel: Feature1ViewModel = applicationViewModel()
    BackdropScaffold(
        modifier = Modifier
            .statusBarsPadding()
            .shadow(16.dp),
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
                NavigateButton(Feature2Screen.route, onNavigateFeature2)
                NavigateButton(Feature3Screen.route, onNavigateFeature3)
                DeepLinkButton(DeeplinkFactory.create(Feature2Screen.route).toUri())
                DeepLinkButton(DeeplinkFactory.create(Feature3Screen.route).toUri())
            }
        }
    )
}

@Composable
private fun NavigateButton(route: String, onNavigate: () -> Unit) {
    Button(onClick = onNavigate) {
        Text(route)
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
