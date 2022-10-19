package app.denis55ka.main.api

import app.denis55ka.core.ApplicationComponentScope
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(ApplicationComponentScope::class)
interface MainDependencies {

    fun getMainRouter(): MainRouter
}
