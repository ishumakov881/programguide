import org.gradle.kotlin.dsl.implementation
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
	alias(libs.plugins.kotlin.multiplatform)
	alias(libs.plugins.jetbrains.compose)
	alias(libs.plugins.android.library)
	alias(libs.plugins.compose.compiler)
}

kotlin {
    jvmToolchain(17)
}

kotlin {
	androidTarget()

	jvm()

	@OptIn(ExperimentalWasmDsl::class)
	wasmJs {
		browser()
		binaries.library()
	}

	applyDefaultHierarchyTemplate()

	sourceSets {		val commonMain by getting {
			dependencies {
				//implementation(project(":programguide"))
				implementation(libs.programguide)
				implementation(compose.material3)
				implementation(libs.material.icons.extended)
			}
		}

		all {
			languageSettings.optIn("androidx.compose.ui.text.ExperimentalTextApi")
			languageSettings.optIn("androidx.compose.material3.ExperimentalMaterial3Api")
		}
	}
}

android {
	namespace = "eu.wewox.programguide.demo"

	compileSdk = libs.versions.sdk.compile.get().toInt()
}
