package app.denis55ka.template

import android.app.Application
import app.denis55ka.core.ApplicationComponentScope
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@MergeComponent(ApplicationComponentScope::class)
interface ApplicationComponent {

    fun getApplication(): Application

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
