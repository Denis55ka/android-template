package app.denis55ka.feature1.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.navigation.MainNavigation
import app.denis55ka.core.navigation.NavContributor
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@MainNavigation
@ContributesMultibinding(ApplicationComponentScope::class)
class Feature1NavContributor @Inject constructor() : NavContributor {

    context(NavGraphBuilder) override fun contribute() {
        composable(Feature1Screen.pattern) { Feature1Screen() }
    }
}
