package app.denis55ka.core.ui.extensions

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import app.denis55ka.core.Components
import app.denis55ka.core.ui.ViewModelDependencies

@Composable
inline fun <reified VM : ViewModel> componentViewModel(
    component: ViewModelDependencies = Components.get(),
    viewModelStoreOwner: ViewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
        "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
    },
    key: String? = null,
): VM = viewModel(viewModelStoreOwner, key, component.viewModelFactory())
