plugins {
    alias(libraries.plugins.android.library)
    alias(libraries.plugins.kotlin.android)
    alias(libraries.plugins.kotlin.serialization)
    id("kotlin-kapt")
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
}

android {
    namespace = "app.denis55ka.core.serialization"
}

dependencies {
    api(project(":core"))

    api(libraries.kotlinx.serialization)

    kapt(libraries.dagger.compiler)
}
