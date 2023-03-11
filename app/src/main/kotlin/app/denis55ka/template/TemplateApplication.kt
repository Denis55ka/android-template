package app.denis55ka.template

import android.app.Application
import app.denis55ka.core.Dependencies

class TemplateApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Dependencies += DaggerApplicationComponent.builder()
            .application(this)
            .build()
    }
}
