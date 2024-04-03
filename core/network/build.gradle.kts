plugins {
    alias(libraries.plugins.kotlin.jvm)
    alias(libraries.plugins.google.ksp)
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
}

dependencies {
    api(project(":core:serialization"))

    // Ktor
    api(libraries.ktor)
    implementation(libraries.ktor.okhttp)
    implementation(libraries.ktor.content.negotiation)
    implementation(libraries.ktor.serialization.json)

    // OkHttp
    api(libraries.okhttp)
    implementation(libraries.okhttp.logging)

    implementation(libraries.dagger)
    ksp(libraries.dagger.compiler)
}
