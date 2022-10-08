package app.denis55ka.main

import android.app.Application
import androidx.lifecycle.ViewModel
import app.denis55ka.core.UserComponentScope
import app.denis55ka.core.ui.ViewModelKey
import com.squareup.anvil.annotations.ContributesMultibinding
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json
import javax.inject.Inject

@ViewModelKey(MainViewModel::class)
@ContributesMultibinding(UserComponentScope::class)
class MainViewModel @Inject constructor(
    private val application: Application,
    private val json: Json,
    private val httpClient: HttpClient,
) : ViewModel()
