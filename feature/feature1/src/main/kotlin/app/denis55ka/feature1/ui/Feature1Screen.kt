package app.denis55ka.feature1.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import app.denis55ka.core.navigation.DeeplinkFactory
import app.denis55ka.core.viewmodel.applicationViewModel
import app.denis55ka.feature2.ui.Feature2Destination
import app.denis55ka.feature3.ui.Feature3Destination

@Composable
fun Feature1Screen(onNavigateFeature2: () -> Unit, onNavigateFeature3: () -> Unit) {
    @Suppress("UNUSED_VARIABLE")
    val viewModel: Feature1ViewModel = applicationViewModel()
    Scaffold { paddings ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddings),
            Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            Alignment.CenterHorizontally
        ) {
            Text("Feature 1")
            NavigateButton(Feature2Destination.route, onNavigateFeature2)
            NavigateButton(Feature3Destination.route, onNavigateFeature3)
            DeepLinkButton(DeeplinkFactory.create(Feature2Destination.route).toUri())
            DeepLinkButton(DeeplinkFactory.create(Feature3Destination.route).toUri())
        }
    }
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
