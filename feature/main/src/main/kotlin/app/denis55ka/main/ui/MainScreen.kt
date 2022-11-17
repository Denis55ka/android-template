package app.denis55ka.main.ui

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LibraryMusic
import androidx.compose.material.icons.rounded.VideoLibrary
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.denis55ka.core.navigation.extension.navigateTab
import app.denis55ka.core.ui.viewmodel.applicationViewModel
import app.denis55ka.feature1.ui.Feature1Screen
import app.denis55ka.feature2.ui.Feature2Screen

@Composable
fun MainScreen(backStackEntry: NavBackStackEntry) {
    val navController = rememberNavController()
    HandleArguments(navController, backStackEntry.arguments)
    val childBackStackEntry by navController.currentBackStackEntryAsState()
    val childRoute = childBackStackEntry?.destination?.route
    val viewModel: MainViewModel = applicationViewModel()
    Column {
        Box(Modifier.weight(1F)) {
            NavHost(navController, Feature1Screen.pattern) {
                viewModel.mainNavContributors.forEach { it.contribute() }
            }
        }
        BottomNavigation(
            Modifier.navigationBarsPadding(),
            backgroundColor = MaterialTheme.colors.surface,
        ) {
            BottomNavigationItem(
                selected = childRoute == Feature1Screen.pattern,
                onClick = { navController.navigateTab(Feature1Screen.route) },
                icon = { Icon(Icons.Rounded.LibraryMusic, contentDescription = null) },
            )
            BottomNavigationItem(
                selected = childRoute == Feature2Screen.pattern,
                onClick = { navController.navigateTab(Feature2Screen.route) },
                icon = { Icon(Icons.Rounded.VideoLibrary, contentDescription = null) },
            )
        }
    }
}

@Composable
private fun HandleArguments(navController: NavHostController, arguments: Bundle?) {
    arguments ?: return
    SideEffect {
        val tab = MainScreen.getTabArg(arguments)
        if (tab != null) {
            when (tab) {
                MainTab.FEATURE1 -> navController.navigateTab(Feature1Screen.route)
                MainTab.FEATURE2 -> navController.navigateTab(Feature2Screen.route)
            }
            arguments.putSerializable(MainScreen.ArgTab, null)
        }
    }
}
