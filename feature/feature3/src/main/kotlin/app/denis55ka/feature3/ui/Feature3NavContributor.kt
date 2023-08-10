package app.denis55ka.feature3.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.navigation.DeeplinkFactory
import app.denis55ka.core.navigation.NavContributor
import app.denis55ka.core.navigation.extension.navigateTab
import app.denis55ka.feature2.ui.Feature2Screen
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(ApplicationComponentScope::class)
class Feature3NavContributor @Inject constructor() : NavContributor {

    context(NavGraphBuilder)
    override fun contribute(navController: NavController) {
        composable(
            Feature3Screen.route,
            deepLinks = listOf(navDeepLink { uriPattern = DeeplinkFactory.create(Feature3Screen.route) }),
        ) {
            Feature3Screen(
                onNavigateFeature2 = { navController.navigateTab(Feature2Screen.route, saveState = false) },
            )
        }
    }
}
