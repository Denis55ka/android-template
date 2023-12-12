package app.denis55ka.feature2

import app.denis55ka.core.navigation.NavContributor
import app.denis55ka.feature2.ui.Feature2NavContributor
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
interface Feature2Module {

    @Binds
    @IntoSet
    fun bindFeature2NavContributor(impl: Feature2NavContributor): NavContributor
}
