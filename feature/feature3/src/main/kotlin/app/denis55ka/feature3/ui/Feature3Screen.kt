package app.denis55ka.feature3.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import app.denis55ka.core.Dependencies
import app.denis55ka.core.ui.SystemUiController

@Composable
internal fun Feature3Screen(onNavigateFeature2: () -> Unit) {
    SystemUiController { colors -> statusBarDarkContentEnabled = colors.isLight }
    @Suppress("UNUSED_VARIABLE")
    val viewModel: Feature3AssistedViewModel = viewModel {
        Dependencies.get<Feature3AssistedViewModel.Dependencies>().factory().create(createSavedStateHandle())
    }
    Scaffold { paddings ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddings),
            Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            Alignment.CenterHorizontally
        ) {
            Text("Feature 3")
            Button(onClick = onNavigateFeature2) {
                Text("Open Feature 2")
            }
        }
    }
}
