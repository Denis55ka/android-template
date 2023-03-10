package app.denis55ka.feature2.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navDeepLink
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.navigation.DeeplinkFactory
import app.denis55ka.core.navigation.MainNavigation
import app.denis55ka.core.navigation.NavContributor
import com.google.accompanist.navigation.animation.composable
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@OptIn(ExperimentalAnimationApi::class)
@MainNavigation
@ContributesMultibinding(ApplicationComponentScope::class)
class Feature2NavContributor @Inject constructor() : NavContributor {

    context(NavGraphBuilder)
    override fun contribute(navController: NavController) {
        composable(
            Feature2Screen.route,
            deepLinks = listOf(navDeepLink { uriPattern = DeeplinkFactory.create(Feature2Screen.route) }),
        ) {
            Feature2Screen()
        }
    }
}
