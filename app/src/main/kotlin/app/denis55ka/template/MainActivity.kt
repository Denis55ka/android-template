package app.denis55ka.template

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LibraryMusic
import androidx.compose.material.icons.rounded.VideoLibrary
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.util.Consumer
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import app.denis55ka.core.navigation.ScreenAnimations
import app.denis55ka.core.navigation.extension.navigateTab
import app.denis55ka.core.ui.theme.Themes
import app.denis55ka.core.ui.viewmodel.applicationViewModel
import app.denis55ka.feature1.ui.Feature1Screen
import app.denis55ka.feature2.ui.Feature2Screen

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val navControllerHolder = NavControllerHolder()
        setContent {
            Themes.Main {
                Content(navControllerHolder)
            }
        }
        addOnNewIntentListener(NewIntentListener(navControllerHolder))
    }
}

@Composable
private fun Content(navControllerHolder: NavControllerHolder) {
    val viewModel: MainActivityViewModel = applicationViewModel()
    val navController = rememberNavController().also { navControllerHolder.navController = it }
    val backStackEntry by navController.currentBackStackEntryAsState()
    val childRoute = backStackEntry?.destination?.route
    Box {
        NavHost(
            navController,
            modifier = Modifier.fillMaxSize(),
            startDestination = Feature1Screen.route,
            enterTransition = { ScreenAnimations.EnterSlide },
            exitTransition = { ScreenAnimations.ExitSlide },
            popEnterTransition = { ScreenAnimations.PopEnterSlide },
            popExitTransition = { ScreenAnimations.PopExitSlide },
        ) {
            viewModel.navContributors.forEach { it.contribute(navController) }
        }
        val visible = childRoute == Feature1Screen.route || childRoute == Feature2Screen.route
        AnimatedVisibility(
            visible,
            Modifier.align(Alignment.BottomCenter),
            enter = slideInVertically { it },
            exit = slideOutVertically { it },
        ) {
            BottomNavigation(
                Modifier
                    .align(Alignment.BottomCenter)
                    .background(MaterialTheme.colors.surface)
                    .navigationBarsPadding(),
                backgroundColor = Color.Unspecified,
                elevation = 0.dp,
            ) {
                BottomNavigationItem(
                    selected = childRoute == Feature1Screen.route,
                    onClick = { navController.navigateTab(Feature1Screen.route) },
                    icon = { Icon(Icons.Rounded.LibraryMusic, contentDescription = null) },
                )
                BottomNavigationItem(
                    selected = childRoute == Feature2Screen.route,
                    onClick = { navController.navigateTab(Feature2Screen.route) },
                    icon = { Icon(Icons.Rounded.VideoLibrary, contentDescription = null) },
                )
            }
        }
    }
}

private class NewIntentListener(
    private val navControllerHolder: NavControllerHolder,
) : Consumer<Intent> {

    override fun accept(value: Intent) {
        val deepLink = value.data ?: return
        val navController = navControllerHolder.navController
        val startDestination = navController.graph.findStartDestination()
        if (startDestination.hasDeepLink(deepLink)) {
            navController.navigate(
                deepLink,
                navOptions {
                    popUpTo(startDestination.id)
                    launchSingleTop = true
                }
            )
        } else if (navController.graph.hasDeepLink(deepLink)) {
            navController.navigate(deepLink)
        }
    }
}

private class NavControllerHolder {

    lateinit var navController: NavController
}
