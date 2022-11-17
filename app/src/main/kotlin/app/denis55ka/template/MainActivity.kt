package app.denis55ka.template

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.view.WindowCompat
import app.denis55ka.core.navigation.LocalNavController
import app.denis55ka.core.navigation.ScreenAnimations
import app.denis55ka.core.ui.SystemUiController
import app.denis55ka.core.ui.theme.Themes
import app.denis55ka.core.ui.viewmodel.applicationViewModels
import app.denis55ka.main.ui.MainScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by applicationViewModels()

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            Themes.Main {
                SystemUiController { colors ->
                    setNavigationBarColor(colors.surface, darkIcons = colors.isLight)
                }
                val navController = rememberAnimatedNavController()
                CompositionLocalProvider(
                    LocalNavController provides navController
                ) {
                    AnimatedNavHost(
                        navController,
                        startDestination = MainScreen().pattern,
                        enterTransition = { ScreenAnimations.EnterSlide },
                        exitTransition = { ScreenAnimations.ExitSlide },
                        popEnterTransition = { ScreenAnimations.PopEnterSlide },
                        popExitTransition = { ScreenAnimations.PopExitSlide },
                    ) {
                        viewModel.navContributors.forEach { it.contribute() }
                    }
                }
            }
        }
    }
}
