package app.denis55ka.template

import android.app.Application
import app.denis55ka.core.navigation.NavigationModule
import app.denis55ka.core.network.NetworkModule
import app.denis55ka.core.serialization.SerializationModule
import app.denis55ka.core.viewmodel.ViewModelDependencies
import app.denis55ka.feature3.Feature3Dependencies
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        SerializationModule::class,
        NetworkModule::class,
        NavigationModule::class,
        FeatureModule::class,
        ApplicationModule::class,
    ]
)
interface ApplicationComponent :
    ViewModelDependencies,
    Feature3Dependencies {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}
