plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
}

android {
    namespace = "app.denis55ka.core"
}

dependencies {
    api(libs.kotlinx.coroutines)

    api(libs.androidx.core)

    api(libs.dagger)
}
