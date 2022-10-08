package app.denis55ka.template

import android.app.Application
import app.denis55ka.core.Components

class TemplateApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Components += DaggerApplicationComponent.builder()
            .application(this)
            .build()

        Components += DaggerUserComponent.builder()
            .applicationComponent(Components.get())
            .build()
    }
}
