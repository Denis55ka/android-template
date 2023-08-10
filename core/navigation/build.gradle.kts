plugins {
    alias(libraries.plugins.android.library)
    alias(libraries.plugins.kotlin.android)
    alias(libraries.plugins.anvil)
}

apply {
    from("$rootDir/gradle/common/android.default.gradle")
    from("$rootDir/gradle/common/android.compose.gradle")
}

android {
    namespace = "app.denis55ka.core.navigation"
}

anvil {
    generateDaggerFactories.set(true)
}

dependencies {
    api(project(":core"))

    api(libraries.androidx.navigation.compose)
}
