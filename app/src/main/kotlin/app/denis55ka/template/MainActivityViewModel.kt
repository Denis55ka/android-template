package app.denis55ka.template

import androidx.lifecycle.ViewModel
import app.denis55ka.core.navigation.NavContributor
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    val navContributors: @JvmSuppressWildcards Set<NavContributor>,
) : ViewModel()
