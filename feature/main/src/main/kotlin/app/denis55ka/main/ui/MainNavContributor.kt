package app.denis55ka.main.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.navigation.NavContributor
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@OptIn(ExperimentalAnimationApi::class)
@ContributesMultibinding(ApplicationComponentScope::class)
class MainNavContributor @Inject constructor() : NavContributor {

    context(NavGraphBuilder) override fun contribute() =
        composable(MainScreen().pattern) { MainScreen(it) }
}
