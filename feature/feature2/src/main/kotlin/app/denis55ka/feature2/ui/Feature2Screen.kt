package app.denis55ka.feature2.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Feature2Screen() {
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
