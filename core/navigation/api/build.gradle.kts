plugins {
    alias(libraries.plugins.kotlin.jvm)
    alias(libraries.plugins.kotlin.serialization)
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
}

dependencies {
    api(project(":core:serialization"))
}
