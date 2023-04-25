pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libraries") {
            from(files("gradle/libs.versions.toml"))
        }
    }
}

include(
    ":core",
    ":core:serialization",
    ":core:network",
    ":core:navigation",
    ":core:ui",
    ":feature:main:api",
    ":feature:main",
    ":feature:feature1:api",
    ":feature:feature1",
    ":feature:feature2:api",
    ":feature:feature2",
    ":feature:feature3:api",
    ":feature:feature3",
    ":app"
)
