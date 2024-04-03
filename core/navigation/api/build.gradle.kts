plugins {
    alias(libraries.plugins.kotlin.jvm)
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
}
