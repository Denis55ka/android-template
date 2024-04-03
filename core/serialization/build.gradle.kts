plugins {
    alias(libraries.plugins.kotlin.jvm)
    alias(libraries.plugins.kotlin.serialization)
    alias(libraries.plugins.google.ksp)
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
}

dependencies {
    api(libraries.kotlinx.serialization)

    implementation(libraries.dagger)
    ksp(libraries.dagger.compiler)
}
