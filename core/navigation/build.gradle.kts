plugins {
    alias(libraries.plugins.android.library)
    alias(libraries.plugins.kotlin.android)
    id("kotlin-kapt")
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
    from("$rootDir/gradle/common/android.compose.gradle")
}

android {
    namespace = "app.denis55ka.core.navigation"
}

dependencies {
    api(project(":core"))

    api(libraries.androidx.navigation.compose)

    kapt(libraries.dagger.compiler)
}
