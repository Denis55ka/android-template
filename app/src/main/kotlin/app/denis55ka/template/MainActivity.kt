package app.denis55ka.template

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import app.denis55ka.core.ComponentHolder
import app.denis55ka.core.ui.theme.Themes

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Themes.Main {
                MainScreen()
            }
        }
    }

    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
        ComponentHolder.component<ApplicationComponent>().viewModelFactory()
}

@Preview
@Composable
fun MainScreen() {
    val viewModel: MainViewModel = viewModel()
    Scaffold(
        topBar = {
            TopAppBar {
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = "Title"
                )
            }
        }
    ) {
        Greeting("Android")
    }
}

@Composable
fun Greeting(name: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Hello $name!"
        )
    }
}
