package app.denis55ka.main.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.navigation.NavContributor
import app.denis55ka.core.navigation.extension.composable
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(ApplicationComponentScope::class)
class MainNavContributor @Inject constructor() : NavContributor {

    context(NavGraphBuilder) override fun contribute(navController: NavController) =
        composable(MainScreen()) { MainScreen(navController, it) }
}
