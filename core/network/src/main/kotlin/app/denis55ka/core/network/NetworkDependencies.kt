package app.denis55ka.core.network

import app.denis55ka.core.ApplicationScope
import com.squareup.anvil.annotations.ContributesTo
import io.ktor.client.HttpClient

@ContributesTo(ApplicationScope::class)
interface NetworkDependencies {

    fun getHttpClient(): HttpClient
}
