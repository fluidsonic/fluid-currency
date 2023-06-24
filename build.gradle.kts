import io.fluidsonic.gradle.*

plugins {
	id("io.fluidsonic.gradle") version "1.3.1"
}

fluidLibrary(name = "currency", version = "0.13.0")

fluidLibraryModule(description = "Kotlin multiplatform currency library") {
	targets {
		common {
			dependencies {
				implementation(kotlinx("serialization-core", "1.5.1"))
			}
		}

		darwin()
		js()
		jvm()
	}
}
