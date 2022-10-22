package app.denis55ka.template

import androidx.lifecycle.ViewModel
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.ui.navigation.NavContributor
import app.denis55ka.core.ui.viewmodel.ViewModelKey
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ViewModelKey(MainActivityViewModel::class)
@ContributesMultibinding(ApplicationComponentScope::class)
class MainActivityViewModel @Inject constructor(
    val navContributors: @JvmSuppressWildcards Set<NavContributor>,
) : ViewModel()
