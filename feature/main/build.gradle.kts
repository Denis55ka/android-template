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
    namespace = "app.denis55ka.main"
}

anvil {
    generateDaggerFactories.set(true)
}

dependencies {
    api(project(":core:network"))
    api(project(":core:navigation"))
    api(project(":core:ui"))
    api(project(":feature:main:api"))
    api(project(":feature:feature1:api"))
    api(project(":feature:feature2:api"))
}
