package app.denis55ka.template

import androidx.lifecycle.SavedStateHandle
import app.denis55ka.core.ui.ViewModelFactory
import app.denis55ka.core.ui.ViewModelFactoryScope
import app.denis55ka.core.ui.ViewModelScope
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component

@ViewModelFactoryScope
@MergeComponent(ViewModelScope::class, dependencies = [ApplicationComponent::class])
interface ViewModelFactoryComponent {

    fun viewModelFactory(): ViewModelFactory

    @Component.Builder
    interface Builder {

        fun parent(component: ApplicationComponent): Builder

        @BindsInstance
        fun bindSavedStateHandle(savedStateHandle: SavedStateHandle): Builder

        fun build(): ViewModelFactoryComponent
    }
}
