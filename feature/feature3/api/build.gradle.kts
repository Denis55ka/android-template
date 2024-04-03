plugins {
    alias(libraries.plugins.kotlin.jvm)
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
}

dependencies {
    implementation(project(":core:navigation:api"))
}
