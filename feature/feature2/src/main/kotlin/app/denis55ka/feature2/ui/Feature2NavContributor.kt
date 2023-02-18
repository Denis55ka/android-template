package app.denis55ka.feature2.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.navigation.MainNavigation
import app.denis55ka.core.navigation.NavContributor
import app.denis55ka.core.navigation.extension.composable
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@MainNavigation
@ContributesMultibinding(ApplicationComponentScope::class)
class Feature2NavContributor @Inject constructor() : NavContributor {

    context(NavGraphBuilder) override fun contribute(navController: NavController) {
        composable(Feature2Screen) { Feature2Screen() }
    }
}
