package app.denis55ka.feature1.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import app.denis55ka.core.ApplicationComponentScope
import app.denis55ka.core.ui.viewmodel.ViewModelKey
import com.squareup.anvil.annotations.ContributesMultibinding
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json
import javax.inject.Inject

@ViewModelKey(Feature1ViewModel::class)
@ContributesMultibinding(ApplicationComponentScope::class)
class Feature1ViewModel @Inject constructor(
    private val application: Application,
    private val json: Json,
    private val httpClient: HttpClient,
) : ViewModel()
