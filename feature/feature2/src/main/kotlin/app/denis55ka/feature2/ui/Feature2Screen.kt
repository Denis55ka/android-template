package app.denis55ka.feature2.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.denis55ka.core.ui.SystemUiController

@Composable
fun Feature2Screen() {
    SystemUiController { colors -> statusBarDarkContentEnabled = colors.isLight }
    Scaffold { paddings ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddings)
        ) {
            Text(
                "Feature 2",
                Modifier.align(Alignment.Center),
            )
        }
    }
}
