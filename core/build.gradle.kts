plugins {
    alias(libraries.plugins.android.library)
    alias(libraries.plugins.kotlin.android)
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
}

android {
    namespace = "app.denis55ka.core"
}

dependencies {
    api(libraries.kotlinx.coroutines)

    api(libraries.androidx.core)

    api(libraries.dagger)
}
