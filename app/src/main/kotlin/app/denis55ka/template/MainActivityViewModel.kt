package app.denis55ka.template

import androidx.lifecycle.ViewModel
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.ui.viewmodel.ViewModelKey
import app.denis55ka.main.api.MainRouter
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ViewModelKey(MainActivityViewModel::class)
@ContributesMultibinding(ApplicationComponentScope::class)
class MainActivityViewModel @Inject constructor(
    val mainRouter: MainRouter,
) : ViewModel()
