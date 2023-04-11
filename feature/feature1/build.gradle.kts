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
    namespace = "app.denis55ka.feature1"
}

anvil {
    generateDaggerFactories.set(true)
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:navigation"))
    implementation(project(":core:ui"))
    api(project(":feature:main:api"))
    api(project(":feature:feature1:api"))
    api(project(":feature:feature3:api"))
}
