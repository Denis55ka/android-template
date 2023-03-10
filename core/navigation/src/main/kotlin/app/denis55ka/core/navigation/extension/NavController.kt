package app.denis55ka.core.navigation.extension

import androidx.navigation.NavController

fun NavController.navigateTab(route: String, saveRestore: Boolean = false) =
    navigate(route) {
        popUpTo(graph.startDestinationId) {
            saveState = saveRestore
        }
        launchSingleTop = true
        restoreState = saveRestore
    }
