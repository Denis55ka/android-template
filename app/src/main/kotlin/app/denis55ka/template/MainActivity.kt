package app.denis55ka.template

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.denis55ka.core.ui.theme.Themes
import app.denis55ka.main.MainScreen

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            Themes.Main {
                NavHost(rememberNavController(), startDestination = "main") {
                    composable("main") {
                        MainScreen()
                    }
                }
            }
        }
    }
}
