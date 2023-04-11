pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libraries") {
            // Versions
            version("compileSdk", "33")
            version("minSdk", "28")

            version("android-gradle-plugin", "7.4.2")
            version("kotlin", "1.8.10")
            version("kotlinx-coroutines", "1.7.0-Beta")
            version("kotlinx-serialization", "1.5.0")
            version("ktor", "2.2.4")
            version("okhttp", "4.10.0")
            version("dagger", "2.45")
            version("anvil", "2.4.4")
            version("androidx-core", "1.10.0")
            version("androidx-appcompat", "1.6.1")
            version("androidx-activity", "1.7.0")
            version("androidx-lifecycle", "2.6.1")
            version("androidx-navigation", "2.5.3")
            version("compose", "1.4.1")
            version("compose-bom", "2023.04.00")
            version("compose-compiler", "1.4.4")
            version("accompanist", "0.30.1")

            // Plugins
            plugin("android-application", "com.android.application").versionRef("android-gradle-plugin")
            plugin("android-library", "com.android.library").versionRef("android-gradle-plugin")

            plugin("kotlin-android", "org.jetbrains.kotlin.android").versionRef("kotlin")
            plugin("kotlin-serialization", "org.jetbrains.kotlin.plugin.serialization").versionRef("kotlin")

            plugin("anvil", "com.squareup.anvil").versionRef("anvil")

            // Libraries
            library("kotlinx-coroutines", "org.jetbrains.kotlinx", "kotlinx-coroutines-android").versionRef("kotlinx-coroutines")
            library("kotlinx-serialization", "org.jetbrains.kotlinx", "kotlinx-serialization-json").versionRef("kotlinx-serialization")

            library("ktor", "io.ktor", "ktor-client-core").versionRef("ktor")
            library("ktor-okhttp", "io.ktor", "ktor-client-okhttp").versionRef("ktor")
            library("ktor-content-negotiation", "io.ktor", "ktor-client-content-negotiation").versionRef("ktor")
            library("ktor-serialization-json", "io.ktor", "ktor-serialization-kotlinx-json").versionRef("ktor")

            library("okhttp", "com.squareup.okhttp3", "okhttp").versionRef("okhttp")
            library("okhttp-logging", "com.squareup.okhttp3", "logging-interceptor").versionRef("okhttp")

            library("dagger", "com.google.dagger", "dagger").versionRef("dagger")
            library("dagger-compiler", "com.google.dagger", "dagger-compiler").versionRef("dagger")

            library("androidx-core", "androidx.core", "core-ktx").versionRef("androidx-core")
            library("androidx-appcompat", "androidx.appcompat", "appcompat").versionRef("androidx-appcompat")
            library("androidx-activity-compose", "androidx.activity", "activity-compose").versionRef("androidx-activity")
            library("androidx-lifecycle-viewmodel-compose", "androidx.lifecycle", "lifecycle-viewmodel-compose").versionRef("androidx-lifecycle")
            library("androidx-navigation-compose", "androidx.navigation", "navigation-compose").versionRef("androidx-navigation")

            library("compose-bom", "androidx.compose", "compose-bom").versionRef("compose-bom")
            library("compose-ui", "androidx.compose.ui", "ui").versionRef("compose")
            library("compose-ui-tooling", "androidx.compose.ui", "ui-tooling").versionRef("compose")
            library("compose-ui-tooling-preview", "androidx.compose.ui", "ui-tooling-preview").versionRef("compose")
            library("compose-foundation", "androidx.compose.foundation", "foundation").versionRef("compose")
            library("compose-material", "androidx.compose.material", "material").versionRef("compose")
            library("compose-material-icons", "androidx.compose.material", "material-icons-core").versionRef("compose")
            library("compose-material-icons-extended", "androidx.compose.material", "material-icons-extended").versionRef("compose")

            library("accompanist-placeholder", "com.google.accompanist", "accompanist-placeholder").versionRef("accompanist")
            library("accompanist-systemuicontroller", "com.google.accompanist", "accompanist-systemuicontroller").versionRef("accompanist")
            library("accompanist-navigation-animation", "com.google.accompanist", "accompanist-navigation-animation").versionRef("accompanist")
        }
    }
}

include(
    ":core",
    ":core:serialization",
    ":core:network",
    ":core:navigation",
    ":core:ui",
    ":feature:main:api",
    ":feature:main",
    ":feature:feature1:api",
    ":feature:feature1",
    ":feature:feature2:api",
    ":feature:feature2",
    ":feature:feature3:api",
    ":feature:feature3",
    ":app"
)
