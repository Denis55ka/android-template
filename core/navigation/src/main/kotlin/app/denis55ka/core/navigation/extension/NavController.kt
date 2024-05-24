package app.denis55ka.core.navigation.extension

import androidx.navigation.NavController

fun <T : Any> NavController.navigateTab(route: T, saveState: Boolean = true) =
    navigate(route) {
        popUpTo(graph.startDestinationId) {
            this.saveState = saveState
        }
        this.launchSingleTop = true
        this.restoreState = true
    }
