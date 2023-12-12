package app.denis55ka.feature1.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json
import javax.inject.Inject

class Feature1ViewModel @Inject constructor(
    private val application: Application,
    private val json: Json,
    private val httpClient: HttpClient,
) : ViewModel()
