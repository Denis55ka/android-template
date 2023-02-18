package app.denis55ka.feature1.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.navigation.MainNavigation
import app.denis55ka.core.navigation.NavContributor
import app.denis55ka.core.navigation.extension.composable
import app.denis55ka.core.navigation.extension.navigate
import app.denis55ka.feature3.ui.Feature3Screen
import app.denis55ka.main.ui.MainScreen
import app.denis55ka.main.ui.MainTab
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@MainNavigation
@ContributesMultibinding(ApplicationComponentScope::class)
class Feature1NavContributor @Inject constructor() : NavContributor {

    context(NavGraphBuilder) override fun contribute(navController: NavController) {
        composable(Feature1Screen) {
            Feature1Screen(
                onNavigateFeature2 = { navController.navigate(MainScreen(MainTab.FEATURE2)) },
                onNavigateFeature3 = { navController.navigate(Feature3Screen) },
            )
        }
    }
}
