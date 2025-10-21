pluginManagement {
    includeBuild("build-logic")
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.7.0")
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        google()
        mavenCentral()

    }
}

rootProject.name = "ProgramGuide"
include(":demo")

//include(":programguide")

include(":desktopdemo")
include(":androiddemo")
include(":wasmdemo")
