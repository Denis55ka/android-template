package app.denis55ka.core.network

import io.ktor.client.HttpClient

interface NetworkDependencies {

    val httpClient: HttpClient
}
