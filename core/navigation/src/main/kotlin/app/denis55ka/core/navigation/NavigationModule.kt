package app.denis55ka.core.navigation

import dagger.Module
import dagger.multibindings.Multibinds

@Module
interface NavigationModule {

    @Multibinds
    fun navContributors(): Set<NavContributor>
}
