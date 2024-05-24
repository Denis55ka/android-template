plugins {
    alias(libraries.plugins.android.library)
    alias(libraries.plugins.kotlin.android)
    alias(libraries.plugins.kotlin.compose)
    alias(libraries.plugins.google.ksp)
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
}

android {
    namespace = "app.denis55ka.core.navigation"
}

dependencies {
    api(project(":core"))
    api(project(":core:navigation:api"))

    api(libraries.androidx.navigation.compose)
    api(libraries.androidx.navigation.fragment.compose)

    ksp(libraries.dagger.compiler)
}
