plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.google.ksp)
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
}

dependencies {
    api(project(":core:serialization"))

    // Ktor
    api(libs.ktor)
    implementation(libs.ktor.okhttp)
    implementation(libs.ktor.content.negotiation)
    implementation(libs.ktor.serialization.json)

    // OkHttp
    api(libs.okhttp)
    implementation(libs.okhttp.logging)

    implementation(libs.dagger)
    ksp(libs.dagger.compiler)
}
