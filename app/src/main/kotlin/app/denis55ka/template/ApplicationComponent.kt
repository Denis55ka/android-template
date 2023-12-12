package app.denis55ka.template

import android.app.Application
import app.denis55ka.core.CoreDependencies
import app.denis55ka.core.navigation.NavigationModule
import app.denis55ka.core.network.NetworkDependencies
import app.denis55ka.core.network.NetworkModule
import app.denis55ka.core.serialization.SerializationDependencies
import app.denis55ka.core.serialization.SerializationModule
import app.denis55ka.core.ui.CoreUiDependencies
import app.denis55ka.feature3.Feature3Dependencies
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        SerializationModule::class,
        NavigationModule::class,
        ApplicationModule::class,
        FeatureModule::class,
    ]
)
interface ApplicationComponent :
    CoreDependencies,
    NetworkDependencies,
    SerializationDependencies,
    CoreUiDependencies,
    Feature3Dependencies {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}
