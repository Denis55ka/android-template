package app.denis55ka.core.network

import app.denis55ka.core.ApplicationComponentScope
import com.squareup.anvil.annotations.ContributesTo
import io.ktor.client.HttpClient

@ContributesTo(ApplicationComponentScope::class)
interface NetworkDependencies {

    fun getHttpClient(): HttpClient
}
