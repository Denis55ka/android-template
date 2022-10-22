package app.denis55ka.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import app.denis55ka.core.Components
import app.denis55ka.core.ui.viewmodel.userViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen() {
    val viewModel: MainViewModel = userViewModel()
    val viewModelAssisted: AssistedViewModel = viewModel {
        Components.get<AssistedViewModel.Dependencies>().factory().create(createSavedStateHandle())
    }
    val systemUiController = rememberSystemUiController()
    SideEffect { systemUiController.statusBarDarkContentEnabled = false }
    BackdropScaffold(
        modifier = Modifier.statusBarsPadding(),
        appBar = { /*TODO*/ },
        backLayerBackgroundColor = Color.Black,
        backLayerContent = { /*TODO*/ },
        frontLayerScrimColor = Color.Unspecified,
        frontLayerContent = {
            Box(Modifier.fillMaxSize()) {
                Text(
                    "Hello Android!",
                    Modifier.align(Alignment.Center),
                )
            }
        }
    )
}
