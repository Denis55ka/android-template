package app.denis55ka.feature1.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navDeepLink
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.navigation.DeeplinkFactory
import app.denis55ka.core.navigation.MainNavigation
import app.denis55ka.core.navigation.NavContributor
import app.denis55ka.core.navigation.extension.navigateTab
import app.denis55ka.feature3.ui.Feature3Screen
import app.denis55ka.main.ui.MainScreen
import app.denis55ka.main.ui.MainTab
import com.google.accompanist.navigation.animation.composable
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@OptIn(ExperimentalAnimationApi::class)
@MainNavigation
@ContributesMultibinding(ApplicationComponentScope::class)
class Feature1NavContributor @Inject constructor() : NavContributor {

    context(NavGraphBuilder)
    override fun contribute(navController: NavController) {
        composable(
            Feature1Screen.route,
            deepLinks = listOf(navDeepLink { uriPattern = DeeplinkFactory.create(Feature1Screen.route) }),
        ) {
            Feature1Screen(
                onNavigateFeature2 = { navController.navigateTab(MainScreen(MainTab.FEATURE2)) },
                onNavigateFeature3 = { navController.navigate(Feature3Screen.route) },
            )
        }
    }
}
