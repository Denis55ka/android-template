package app.denis55ka.template

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LibraryMusic
import androidx.compose.material.icons.rounded.VideoLibrary
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.util.Consumer
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import app.denis55ka.core.navigation.ScreenAnimations
import app.denis55ka.core.navigation.extension.navigateTab
import app.denis55ka.core.ui.theme.Themes
import app.denis55ka.core.viewmodel.applicationViewModel
import app.denis55ka.feature1.ui.Feature1Destination
import app.denis55ka.feature2.ui.Feature2Destination

class MainActivity : ComponentActivity() {

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
    Box {
        NavHost(
            navController,
            modifier = Modifier.fillMaxSize(),
            startDestination = Feature1Destination,
            enterTransition = { ScreenAnimations.EnterSlide },
            exitTransition = { ScreenAnimations.ExitSlide },
            popEnterTransition = { ScreenAnimations.PopEnterSlide },
            popExitTransition = { ScreenAnimations.PopExitSlide },
        ) {
            viewModel.navContributors.forEach { it.contribute(navController) }
        }
        val has1Destination = backStackEntry?.destination?.hasRoute<Feature1Destination>() == true
        val has2Destination = backStackEntry?.destination?.hasRoute<Feature2Destination>() == true
        val visible = has1Destination || has2Destination
        AnimatedVisibility(
            visible,
            Modifier.align(Alignment.BottomCenter),
            enter = slideInVertically { it },
            exit = slideOutVertically { it },
        ) {
            NavigationBar(
                Modifier
                    .align(Alignment.BottomCenter)
                    .background(MaterialTheme.colorScheme.surface)
                    .navigationBarsPadding(),
                containerColor = Color.Unspecified,
                tonalElevation = 0.dp,
            ) {
                NavigationBarItem(
                    selected = has1Destination,
                    onClick = { navController.navigateTab(Feature1Destination) },
                    icon = { Icon(Icons.Rounded.LibraryMusic, contentDescription = null) },
                )
                NavigationBarItem(
                    selected = has2Destination,
                    onClick = { navController.navigateTab(Feature2Destination) },
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
