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
    namespace = "app.denis55ka.core.viewmodel"
}

dependencies {
    api(project(":core"))

    // AndroidX
    api(libraries.androidx.activity.compose)
    api(libraries.androidx.lifecycle.viewmodel.compose)

    implementation(libraries.dagger)
    ksp(libraries.dagger.compiler)
}
