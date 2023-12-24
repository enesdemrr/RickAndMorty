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
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "RickAndMorty"
include(":app")
include(":feature")
include(":common")
include(":navigation")
include(":common:data")
include(":common:domain")
include(":common:presentation")
include(":feature:detail")
include(":feature:home")
include(":feature:login")
include(":feature:detail:data")
include(":feature:detail:domain")
include(":feature:detail:presentation")
include(":feature:home:data")
include(":feature:home:domain")
include(":feature:home:presentation")
include(":feature:login:data")
include(":feature:login:domain")
include(":feature:login:presentation")
