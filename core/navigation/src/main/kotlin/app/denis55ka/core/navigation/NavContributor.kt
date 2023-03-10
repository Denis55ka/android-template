package app.denis55ka.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface NavContributor {

    context(NavGraphBuilder)
    fun contribute(navController: NavController)
}
