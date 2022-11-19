package app.denis55ka.main.ui

import android.os.Bundle
import app.denis55ka.core.navigation.Screen

class MainScreen(tab: MainTab? = null) : Screen("main?tab={$ArgTab}", "main?tab=$tab") {

    companion object {

        const val ArgTab = "tab"

        fun getTabArg(bundle: Bundle): MainTab? = bundle.getString(ArgTab)?.let { MainTab.valueOf(it) }
    }
}

enum class MainTab {

    FEATURE1, FEATURE2
}
