package app.denis55ka.core.ui

import app.denis55ka.core.ui.viewmodel.ApplicationViewModelFactory

interface CoreUiDependencies {

    fun applicationViewModelFactory(): ApplicationViewModelFactory
}
