plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.ksp)
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

    api(libs.androidx.navigation.compose)
    api(libs.androidx.navigation.fragment.compose)

    ksp(libs.dagger.compiler)
}
