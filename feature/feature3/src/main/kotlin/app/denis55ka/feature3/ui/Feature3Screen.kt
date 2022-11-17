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
import app.denis55ka.core.Components
import app.denis55ka.core.navigation.LocalNavController
import app.denis55ka.core.navigation.extension.navigate
import app.denis55ka.core.ui.SystemUiController
import app.denis55ka.main.ui.MainScreen
import app.denis55ka.main.ui.MainTab

@Composable
fun Feature3Screen() {
    SystemUiController { colors -> statusBarDarkContentEnabled = colors.isLight }
    val navController = LocalNavController.current
    val viewModel: Feature3AssistedViewModel = viewModel {
        Components.get<Feature3AssistedViewModel.Dependencies>().factory().create(createSavedStateHandle())
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
            Button(onClick = { navController.navigate(MainScreen(MainTab.FEATURE2)) }) {
                Text("Open Feature 2")
            }
        }
    }
}
