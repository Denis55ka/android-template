package app.denis55ka.template

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import app.denis55ka.core.Components
import app.denis55ka.core.ui.extensions.defaultViewModel
import app.denis55ka.core.ui.theme.Themes
import app.denis55ka.main.MainViewModel
import app.denis55ka.main.MainViewModelAssisted

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            Themes.Main {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainScreen() {
    val viewModel: MainViewModel = defaultViewModel()
    val viewModelAssisted: MainViewModelAssisted = viewModel {
        Components.get<MainViewModelAssisted.Dependencies>().factory().create(createSavedStateHandle())
    }
    Scaffold { paddings ->
        Box(
            Modifier
                .padding(paddings)
                .fillMaxSize()
        ) {
            Text(
                "Hello Android!",
                Modifier.align(Alignment.Center),
            )
        }
    }
}
