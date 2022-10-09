package app.denis55ka.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import app.denis55ka.core.UserComponentScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json

class AssistedViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val json: Json,
    private val httpClient: HttpClient,
) : ViewModel() {

    @AssistedFactory
    interface Factory {

        fun create(savedStateHandle: SavedStateHandle): AssistedViewModel
    }

    @ContributesTo(UserComponentScope::class)
    interface Dependencies {

        fun factory(): Factory
    }
}
