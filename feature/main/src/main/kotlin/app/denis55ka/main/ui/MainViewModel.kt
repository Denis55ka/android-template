package app.denis55ka.main.ui

import androidx.lifecycle.ViewModel
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.navigation.MainNavigation
import app.denis55ka.core.navigation.NavContributor
import app.denis55ka.core.ui.viewmodel.ViewModelKey
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ViewModelKey(MainViewModel::class)
@ContributesMultibinding(ApplicationComponentScope::class)
class MainViewModel @Inject constructor(
    @MainNavigation
    val mainNavContributors: @JvmSuppressWildcards Set<NavContributor>
) : ViewModel()
