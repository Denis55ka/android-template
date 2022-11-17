package app.denis55ka.core.navigation.extension

import androidx.navigation.NavController
import app.denis55ka.core.navigation.Screen

fun NavController.navigateTab(route: String) =
    navigate(route) {
        val startDestinationRoute = graph.startDestinationRoute
        if (startDestinationRoute != null) {
            popUpTo(startDestinationRoute) {
                saveState = true
            }
        }
        launchSingleTop = true
        restoreState = true
    }

fun NavController.navigate(screen: Screen) {
    popBackStack(screen.pattern, inclusive = false)
    navigate(screen.route) {
        launchSingleTop = true
    }
}
