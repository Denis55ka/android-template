package app.denis55ka.main.ui

import android.os.Bundle
import app.denis55ka.core.navigation.Screen

object MainScreen : Screen() {

    const val ArgTab = "tab"

    override val route = "main?tab={$ArgTab}"

    operator fun invoke(tab: MainTab? = null): String = "main?tab=$tab"

    fun getTabArg(bundle: Bundle): MainTab? = bundle.getString(ArgTab)?.let { MainTab.valueOf(it) }
}

enum class MainTab {

    FEATURE1, FEATURE2
}
