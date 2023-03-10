package app.denis55ka.core.navigation

object DeeplinkFactory {

    private const val DeepLinkHost = "denis55ka://template/"

    fun create(route: String): String = DeepLinkHost + route
}
