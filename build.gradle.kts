import io.fluidsonic.gradle.*

plugins {
	id("io.fluidsonic.gradle") version "3.0.0"
}

fluidLibrary(name = "currency", version = "0.14.0")

fluidLibraryModule(description = "Kotlin multiplatform currency library") {
	targets {
		common {
			dependencies {
				implementation(kotlinx("serialization-core", "1.10.0"))
			}
			testDependencies {
				implementation(kotlinx("serialization-json", "1.10.0"))
			}
		}

		js()
		jvm()
	}
}
