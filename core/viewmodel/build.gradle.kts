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
    namespace = "app.denis55ka.core.viewmodel"
}

dependencies {
    api(project(":core"))

    // AndroidX
    api(libs.androidx.activity.compose)
    api(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.dagger)
    ksp(libs.dagger.compiler)
}
