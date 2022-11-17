package app.denis55ka.feature1.ui

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.denis55ka.core.navigation.LocalNavController
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
    val navController = LocalNavController.current
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
                Button(onClick = { navController.navigate(MainScreen(MainTab.FEATURE2)) }) {
                    Text("Open Feature 2")
                }
                Button(onClick = { navController.navigate(Feature3Screen) }) {
                    Text("Open Feature 3")
                }
            }
        }
    )
}
