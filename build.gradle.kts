import io.fluidsonic.gradle.*

plugins {
	id("io.fluidsonic.gradle") version "1.1.7"
}

fluidLibrary(name = "currency", version = "0.9.0")

fluidLibraryModule(description = "Kotlin multiplatform currency library") {
	targets {
		darwin()
		js()
		jvm()
	}
}
