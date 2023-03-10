package app.denis55ka.main.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LibraryMusic
import androidx.compose.material.icons.rounded.VideoLibrary
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import app.denis55ka.core.navigation.extension.navigateTab
import app.denis55ka.core.ui.viewmodel.applicationViewModel
import app.denis55ka.feature1.ui.Feature1Screen
import app.denis55ka.feature2.ui.Feature2Screen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(parentNavController: NavController, backStackEntry: NavBackStackEntry) {
    val navController = rememberAnimatedNavController()
    val childBackStackEntry by navController.currentBackStackEntryAsState()
    val childRoute = childBackStackEntry?.destination?.route
    val viewModel: MainViewModel = applicationViewModel()
    NavigationHandler(backStackEntry) { route -> navController.navigateTab(route, saveRestore = true) }
    Scaffold(
        content = { paddings ->
            AnimatedNavHost(navController, Feature1Screen.route, Modifier.padding(paddings)) {
                viewModel.navContributors.forEach { it.contribute(parentNavController) }
            }
        },
        bottomBar = {
            BottomNavigation(
                Modifier.navigationBarsPadding(),
                backgroundColor = MaterialTheme.colors.surface,
            ) {
                BottomNavigationItem(
                    selected = childRoute == Feature1Screen.route,
                    onClick = { navController.navigateTab(Feature1Screen.route, saveRestore = true) },
                    icon = { Icon(Icons.Rounded.LibraryMusic, contentDescription = null) },
                )
                BottomNavigationItem(
                    selected = childRoute == Feature2Screen.route,
                    onClick = { navController.navigateTab(Feature2Screen.route, saveRestore = true) },
                    icon = { Icon(Icons.Rounded.VideoLibrary, contentDescription = null) },
                )
            }
        }
    )
}

@Composable
private fun NavigationHandler(backStackEntry: NavBackStackEntry, onNavigate: (route: String) -> Unit) {
    val arguments = backStackEntry.arguments ?: return
    val bundle = rememberSaveable(backStackEntry) { arguments }
    LaunchedEffect(bundle) {
        val tab = MainScreen.getTabArg(bundle)
        if (tab != null) {
            when (tab) {
                MainTab.FEATURE1 -> onNavigate(Feature1Screen.route)
                MainTab.FEATURE2 -> onNavigate(Feature2Screen.route)
            }
            bundle.remove(MainScreen.ArgTab)
        }
    }
}
