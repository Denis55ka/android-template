import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libraries.plugins.android.application) apply false
    alias(libraries.plugins.android.library) apply false
    alias(libraries.plugins.kotlin.android) apply false
    alias(libraries.plugins.kotlin.serialization) apply false
    alias(libraries.plugins.anvil) apply false
}

allprojects {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
            freeCompilerArgs.addAll("-Xcontext-receivers")
        }
    }
}
