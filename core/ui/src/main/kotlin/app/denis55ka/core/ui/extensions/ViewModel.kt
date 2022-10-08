package app.denis55ka.core.ui.extensions

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import app.denis55ka.core.Components
import app.denis55ka.core.ui.ViewModelDependencies

@Composable
inline fun <reified VM : ViewModel> defaultViewModel(
    viewModelStoreOwner: ViewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
        "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
    },
    key: String? = null,
): VM = componentViewModel(Components.get(), viewModelStoreOwner, key)

@Composable
inline fun <reified C : ViewModelDependencies, reified VM : ViewModel> componentViewModel(
    component: C = Components.get(),
    viewModelStoreOwner: ViewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
        "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
    },
    key: String? = null,
): VM = viewModel(viewModelStoreOwner, key, component.viewModelFactory())
