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
    namespace = "app.denis55ka.feature1"
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:navigation"))
    implementation(project(":core:viewmodel"))
    implementation(project(":core:ui"))

    api(project(":feature:feature1:api"))
    api(project(":feature:feature2:api"))
    api(project(":feature:feature3:api"))

    ksp(libraries.dagger.compiler)
}
