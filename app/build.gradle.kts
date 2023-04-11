import com.android.build.gradle.ProguardFiles

plugins {
    alias(libraries.plugins.android.application)
    alias(libraries.plugins.kotlin.android)
    alias(libraries.plugins.anvil)
    id("kotlin-kapt")
}

apply {
    from("$rootDir/gradle/common/android.default.gradle")
    from("$rootDir/gradle/common/android.compose.gradle")
}

android {
    namespace = "app.denis55ka.template"

    defaultConfig {
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

    packagingOptions {
        resources {
            excludes += "/META-INF/versions/**"
        }
    }
}

dependencies {
    implementation(project(":feature:main"))
    implementation(project(":feature:feature1"))
    implementation(project(":feature:feature2"))
    implementation(project(":feature:feature3"))

    kapt(libraries.dagger.compiler)
}
