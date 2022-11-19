package app.denis55ka.template

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.view.WindowCompat
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.navOptions
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

    private lateinit var navController: NavHostController

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            Themes.Main {
                SystemUiController { colors ->
                    setNavigationBarColor(colors.surface, darkIcons = colors.isLight)
                }
                navController = rememberAnimatedNavController()
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

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val deepLink = intent?.data ?: return
        val startDestination = navController.graph.findStartDestination()
        if (startDestination.hasDeepLink(deepLink)) {
            navController.navigate(deepLink, navOptions {
                popUpTo(startDestination.id)
                launchSingleTop = true
            })
        } else if (navController.graph.hasDeepLink(deepLink)) {
            navController.navigate(deepLink)
        }
    }
}
