package app.denis55ka.feature3.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import app.denis55ka.core.navigation.DeeplinkFactory
import app.denis55ka.core.navigation.NavContributor
import app.denis55ka.core.navigation.extension.navigateTab
import app.denis55ka.feature2.ui.Feature2Destination
import javax.inject.Inject

class Feature3NavContributor @Inject constructor() : NavContributor {

    context(NavGraphBuilder)
    override fun contribute(navController: NavController) {
        composable(
            Feature3Destination.route,
            deepLinks = listOf(navDeepLink { uriPattern = DeeplinkFactory.create(Feature3Destination.route) }),
        ) {
            Feature3Screen(
                onNavigateFeature2 = { navController.navigateTab(Feature2Destination.route, saveState = false) },
            )
        }
    }
}
