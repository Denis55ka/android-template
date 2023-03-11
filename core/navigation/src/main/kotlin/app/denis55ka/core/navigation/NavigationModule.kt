package app.denis55ka.core.navigation

import app.denis55ka.core.ApplicationComponentScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.multibindings.Multibinds

@Module
@ContributesTo(ApplicationComponentScope::class)
interface NavigationModule {

    @Multibinds
    fun navContributors(): Set<NavContributor>

    @Multibinds
    @MainNavigation
    fun mainNavContributors(): Set<NavContributor>
}
