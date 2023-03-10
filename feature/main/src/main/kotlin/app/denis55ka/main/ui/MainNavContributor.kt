package app.denis55ka.main.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navDeepLink
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.navigation.DeeplinkFactory
import app.denis55ka.core.navigation.NavContributor
import com.google.accompanist.navigation.animation.composable
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@OptIn(ExperimentalAnimationApi::class)
@ContributesMultibinding(ApplicationComponentScope::class)
class MainNavContributor @Inject constructor() : NavContributor {

    context(NavGraphBuilder)
    override fun contribute(navController: NavController) {
        composable(
            MainScreen.route,
            deepLinks = listOf(navDeepLink { uriPattern = DeeplinkFactory.create(MainScreen.route) }),
        ) {
            MainScreen(navController, it)
        }
    }
}
