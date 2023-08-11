plugins {
    alias(libraries.plugins.android.library)
    alias(libraries.plugins.kotlin.android)
    alias(libraries.plugins.anvil)
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
}

android {
    namespace = "app.denis55ka.core.network"
    buildFeatures {
        buildConfig = true
    }
}

anvil {
    generateDaggerFactories.set(true)
}

dependencies {
    api(project(":core"))
    api(project(":core:serialization"))

    // Ktor
    api(libraries.ktor)
    implementation(libraries.ktor.okhttp)
    implementation(libraries.ktor.content.negotiation)
    implementation(libraries.ktor.serialization.json)

    // OkHttp
    api(libraries.okhttp)
    implementation(libraries.okhttp.logging)
}
