package app.denis55ka.feature1.ui

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import app.denis55ka.core.navigation.DeeplinkFactory
import app.denis55ka.core.navigation.NavContributor
import app.denis55ka.core.navigation.extension.navigateTab
import app.denis55ka.feature2.ui.Feature2Destination
import app.denis55ka.feature3.ui.Feature3Destination
import javax.inject.Inject

class Feature1NavContributor @Inject constructor() : NavContributor {

    context(NavGraphBuilder)
    override fun contribute(navController: NavController) {
        composable<Feature1Destination>(
            deepLinks = listOf(navDeepLink { uriPattern = DeeplinkFactory.create(Feature1Destination.route) }),
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() },
        ) {
            Feature1Screen(
                onNavigateFeature2 = { navController.navigateTab(Feature2Destination) },
                onNavigateFeature3 = { navController.navigate(Feature3Destination) },
            )
        }
    }
}
