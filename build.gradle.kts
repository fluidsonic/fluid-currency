import io.fluidsonic.gradle.*
import org.jetbrains.kotlin.gradle.plugin.*

plugins {
	id("io.fluidsonic.gradle") version "1.3.1"
}

fluidLibrary(name = "currency", version = "0.12.0")

fluidLibraryModule(description = "Kotlin multiplatform currency library") {
	targets {
		common {
			dependencies {
				implementation(kotlinx("serialization-core", "1.5.1"))
			}
		}

		darwin()
		js(KotlinJsCompilerType.BOTH)
		jvm()
	}
}
