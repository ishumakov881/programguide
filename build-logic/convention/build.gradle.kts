plugins {
    `kotlin-dsl`
}

java {
    toolchain {
        val version = 17//libs.versions.java.toolchain.get()
        languageVersion.set(JavaLanguageVersion.of(version))
    }
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "convention.jvm.toolchain"
            implementationClass = "JvmToolchainConventionPlugin"
        }
    }
}
