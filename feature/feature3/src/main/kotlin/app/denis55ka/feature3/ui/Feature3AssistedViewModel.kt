package app.denis55ka.feature3.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import app.denis55ka.core.UserComponentScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json

class Feature3AssistedViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val json: Json,
    private val httpClient: HttpClient,
) : ViewModel() {

    @AssistedFactory
    interface Factory {

        fun create(savedStateHandle: SavedStateHandle): Feature3AssistedViewModel
    }

    @ContributesTo(UserComponentScope::class)
    interface Dependencies {

        fun factory(): Factory
    }
}
