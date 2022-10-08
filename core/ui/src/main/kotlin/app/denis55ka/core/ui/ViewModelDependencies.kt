package app.denis55ka.core.ui

import app.denis55ka.core.UserComponentScope
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(UserComponentScope::class)
interface ViewModelDependencies {

    fun viewModelFactory(): ViewModelFactory
}
