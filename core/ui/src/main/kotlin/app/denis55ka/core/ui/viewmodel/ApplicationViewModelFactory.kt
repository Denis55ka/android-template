package app.denis55ka.core.ui.viewmodel

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import app.denis55ka.core.Dependencies
import app.denis55ka.core.ui.CoreUiDependencies
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ApplicationViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    init {
        Log.d("ViewModelProvider.Factory", "ApplicationViewModelFactory.init, creators = $creators")
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = requireNotNull(creators[modelClass]?.get() as? T)
}

inline fun <reified VM : ViewModel> ComponentActivity.applicationViewModels(): Lazy<VM> =
    viewModels { Dependencies.get<CoreUiDependencies>().applicationViewModelFactory() }

@Composable
inline fun <reified VM : ViewModel> applicationViewModel(key: String? = null): VM {
    val factory = remember { Dependencies.get<CoreUiDependencies>().applicationViewModelFactory() }
    return viewModel(key = key, factory = factory)
}
