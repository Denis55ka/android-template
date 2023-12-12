plugins {
    alias(libraries.plugins.android.library)
    alias(libraries.plugins.kotlin.android)
    alias(libraries.plugins.kotlin.serialization)
    alias(libraries.plugins.google.ksp)
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

    ksp(libraries.dagger.compiler)
}
