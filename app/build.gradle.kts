import com.android.build.gradle.ProguardFiles

plugins {
    alias(libraries.plugins.android.application)
    alias(libraries.plugins.kotlin.android)
    alias(libraries.plugins.google.ksp)
}

apply {
    from("$rootDir/gradle/common/kotlin.gradle")
    from("$rootDir/gradle/common/android.compose.gradle")
}

android {
    namespace = "app.denis55ka.template"

    defaultConfig {
        targetSdk = 34
        applicationId = namespace
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile(ProguardFiles.ProguardFile.OPTIMIZE.fileName), "proguard/rules.pro")

            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:navigation"))
    implementation(project(":core:viewmodel"))
    implementation(project(":core:ui"))

    implementation(project(":feature:feature1"))
    implementation(project(":feature:feature2"))
    implementation(project(":feature:feature3"))

    ksp(libraries.dagger.compiler)
}
