package app.denis55ka.core.navigation

abstract class Screen(
    val pattern: String,
    val route: String = pattern,
    val deepLinks: List<String> = listOf(DeepLinkHost + pattern)
)

const val DeepLinkHost = "denis55ka://template/"
