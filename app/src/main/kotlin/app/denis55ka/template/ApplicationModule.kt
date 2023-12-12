package app.denis55ka.template

import androidx.lifecycle.ViewModel
import app.denis55ka.core.ui.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ApplicationModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    fun bindMainActivityViewModel(impl: MainActivityViewModel): ViewModel
}
