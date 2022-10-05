package app.denis55ka.template

import android.app.Application
import app.denis55ka.core.ComponentHolder

class TemplateApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ComponentHolder.components += DaggerApplicationComponent.create()
    }
}
