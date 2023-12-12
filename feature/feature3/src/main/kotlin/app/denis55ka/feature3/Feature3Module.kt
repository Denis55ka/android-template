package app.denis55ka.feature3

import app.denis55ka.core.navigation.NavContributor
import app.denis55ka.feature3.ui.Feature3NavContributor
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
interface Feature3Module {

    @Binds
    @IntoSet
    fun bindFeature3NavContributor(impl: Feature3NavContributor): NavContributor
}
