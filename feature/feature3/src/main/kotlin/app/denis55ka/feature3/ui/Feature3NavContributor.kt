package app.denis55ka.feature3.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.navigation.NavContributor
import app.denis55ka.core.navigation.extension.composable
import app.denis55ka.core.navigation.extension.navigate
import app.denis55ka.main.ui.MainScreen
import app.denis55ka.main.ui.MainTab
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(ApplicationComponentScope::class)
class Feature3NavContributor @Inject constructor() : NavContributor {

    context(NavGraphBuilder) override fun contribute(navController: NavController) {
        composable(Feature3Screen) {
            Feature3Screen(
                onNavigateFeature2 = { navController.navigate(MainScreen(MainTab.FEATURE2)) },
            )
        }
    }
}
