package app.denis55ka.feature3.ui

import androidx.navigation.NavGraphBuilder
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.navigation.NavContributor
import app.denis55ka.core.navigation.extension.composable
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(ApplicationComponentScope::class)
class Feature3NavContributor @Inject constructor() : NavContributor {

    context(NavGraphBuilder) override fun contribute() {
        composable(Feature3Screen) { Feature3Screen() }
    }
}
