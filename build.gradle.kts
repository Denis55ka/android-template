import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libraries.plugins.android.application) apply false
    alias(libraries.plugins.android.library) apply false
    alias(libraries.plugins.kotlin.android) apply false
    alias(libraries.plugins.kotlin.serialization) apply false
    alias(libraries.plugins.anvil) apply false
    alias(libraries.plugins.google.ksp) apply false
}

allprojects {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            freeCompilerArgs.addAll("-Xcontext-receivers")
        }
    }
}
