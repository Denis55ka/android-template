plugins {
    alias(libraries.plugins.android.library)
    alias(libraries.plugins.kotlin.android)
    alias(libraries.plugins.google.ksp)
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

    ksp(libraries.dagger.compiler)
}
