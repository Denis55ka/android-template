plugins {
    alias(libraries.plugins.android.library)
    alias(libraries.plugins.kotlin.android)
}

apply {
    from("$rootDir/gradle/common/android.default.gradle")
}

android {
    namespace = "app.denis55ka.feature2.api"
}

dependencies {
    implementation(project(":core:navigation"))
}
