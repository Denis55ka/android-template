plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
}

dependencies {
    implementation(project(":core:navigation:api"))
}
