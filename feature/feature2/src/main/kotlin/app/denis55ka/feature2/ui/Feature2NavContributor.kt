package app.denis55ka.feature2.ui

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import app.denis55ka.core.navigation.DeeplinkFactory
import app.denis55ka.core.navigation.NavContributor
import javax.inject.Inject

class Feature2NavContributor @Inject constructor() : NavContributor {

    context(NavGraphBuilder)
    override fun contribute(navController: NavController) {
        composable(
            Feature2Destination.route,
            deepLinks = listOf(navDeepLink { uriPattern = DeeplinkFactory.create(Feature2Destination.route) }),
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() },
        ) {
            Feature2Screen()
        }
    }
}
