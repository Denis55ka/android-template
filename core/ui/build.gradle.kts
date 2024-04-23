plugins {
    alias(libraries.plugins.android.library)
    alias(libraries.plugins.kotlin.android)
    alias(libraries.plugins.google.ksp)
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
    from("$rootDir/gradle/common/android.compose.gradle")
}

android {
    namespace = "app.denis55ka.core.ui"
}

dependencies {
    api(project(":core"))

    // AndroidX
    api(libraries.androidx.appcompat)
    api(libraries.androidx.activity.compose)
    api(libraries.androidx.lifecycle.viewmodel.compose)
    api(libraries.androidx.lifecycle.runtime.compose)

    // Compose
    api(platform(libraries.androidx.compose.bom))
    api(libraries.androidx.compose.ui)
    api(libraries.androidx.compose.ui.tooling)
    api(libraries.androidx.compose.ui.tooling.preview)
    api(libraries.androidx.compose.foundation)
    api(libraries.androidx.compose.material3)
    api(libraries.androidx.compose.material.icons.core)
    api(libraries.androidx.compose.material.icons.extended)

    // Accompanist
    api(libraries.accompanist.placeholder)

    ksp(libraries.dagger.compiler)
}
