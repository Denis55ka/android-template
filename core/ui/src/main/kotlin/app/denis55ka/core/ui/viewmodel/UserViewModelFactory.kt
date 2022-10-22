package app.denis55ka.core.ui.viewmodel

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import app.denis55ka.core.Components
import app.denis55ka.core.UserComponentScope
import app.denis55ka.core.UserScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.multibindings.Multibinds
import javax.inject.Inject
import javax.inject.Provider

@UserScope
class UserViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    init {
        Log.d("ViewModelProvider.Factory", "UserViewModelFactory.init, creators = $creators")
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = requireNotNull(creators[modelClass]?.get() as? T)

    @ContributesTo(UserComponentScope::class)
    interface Dependencies {

        fun viewModelFactory(): UserViewModelFactory
    }

    @Module
    @ContributesTo(UserComponentScope::class)
    interface MultibindsModule {

        @Multibinds
        fun bindCreators(): Map<Class<out ViewModel>, ViewModel>
    }
}

inline fun <reified VM : ViewModel> ComponentActivity.userViewModels(): Lazy<VM> =
    viewModels { Components.get<UserViewModelFactory.Dependencies>().viewModelFactory() }

@Composable
inline fun <reified VM : ViewModel> userViewModel(key: String? = null): VM {
    val factory = remember(Components.get<UserViewModelFactory.Dependencies>()::viewModelFactory)
    return viewModel(key = key, factory = factory)
}
