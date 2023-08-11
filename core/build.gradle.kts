plugins {
    alias(libraries.plugins.android.library)
    alias(libraries.plugins.kotlin.android)
    alias(libraries.plugins.anvil)
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
}

android {
    namespace = "app.denis55ka.core"
}

anvil {
    generateDaggerFactories.set(true)
}

dependencies {
    api(libraries.kotlinx.coroutines)

    api(libraries.androidx.core)

    api(libraries.dagger)
}
