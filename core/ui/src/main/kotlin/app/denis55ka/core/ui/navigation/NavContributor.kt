package app.denis55ka.core.ui.navigation

import androidx.navigation.NavGraphBuilder

interface NavContributor {

    context(NavGraphBuilder) fun contribute()
}
