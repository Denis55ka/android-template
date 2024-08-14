plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.google.ksp)
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
}

dependencies {
    api(libs.kotlinx.serialization)

    implementation(libs.dagger)
    ksp(libs.dagger.compiler)
}
