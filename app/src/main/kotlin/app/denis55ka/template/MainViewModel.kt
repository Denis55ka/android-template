package app.denis55ka.template

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import app.denis55ka.core.ui.ViewModelKey
import app.denis55ka.core.ui.ViewModelScope
import com.squareup.anvil.annotations.ContributesMultibinding
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json
import javax.inject.Inject

@ViewModelKey(MainViewModel::class)
@ContributesMultibinding(ViewModelScope::class)
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val json: Json,
    private val httpClient: HttpClient,
) : ViewModel()
