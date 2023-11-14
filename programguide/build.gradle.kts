plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.kotlin.multiplatform)
	alias(libs.plugins.jetbrains.compose)
	alias(libs.plugins.mavenpublish)
	id("convention.jvm.toolchain")
}

kotlin {
	androidTarget()

	jvm()

	iosX64()
	iosArm64()
	iosSimulatorArm64()

	applyDefaultHierarchyTemplate()

	sourceSets {
		val commonMain by getting {
			dependencies {
				api(compose.runtime)
				api(compose.foundation)

				api(libs.minabox)
			}
		}
	}
}

android {
	namespace = "eu.wewox.programguide"

	compileSdk = libs.versions.sdk.compile.get().toInt()

	defaultConfig {
		minSdk = libs.versions.sdk.min.get().toInt()
	}
	buildFeatures {
		compose = true
	}
	kotlin {
		explicitApi()

		androidTarget {
			publishLibraryVariants("release", "debug")
		}
	}
	composeOptions {
		kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
	}
}
