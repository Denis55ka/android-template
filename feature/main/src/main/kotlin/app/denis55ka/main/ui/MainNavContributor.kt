package app.denis55ka.main.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.navigation.NavContributor
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(ApplicationComponentScope::class)
class MainNavContributor @Inject constructor() : NavContributor {

    context(NavGraphBuilder) override fun contribute() =
        composable(MainRoute.value) { MainScreen() }
}
