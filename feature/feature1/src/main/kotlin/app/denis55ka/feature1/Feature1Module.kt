package app.denis55ka.feature1

import androidx.lifecycle.ViewModel
import app.denis55ka.core.navigation.NavContributor
import app.denis55ka.core.viewmodel.ViewModelKey
import app.denis55ka.feature1.ui.Feature1NavContributor
import app.denis55ka.feature1.ui.Feature1ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet

@Module
interface Feature1Module {

    @Binds
    @IntoSet
    fun bindFeature1NavContributor(impl: Feature1NavContributor): NavContributor

    @Binds
    @IntoMap
    @ViewModelKey(Feature1ViewModel::class)
    fun bindFeature1ViewModel(impl: Feature1ViewModel): ViewModel
}
