package app.denis55ka.main

import androidx.compose.runtime.Composable
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.main.api.MainRouter
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(ApplicationComponentScope::class)
class MainRouterImpl @Inject constructor() : MainRouter {

    @Composable
    override fun Navigate() = MainScreen()
}
