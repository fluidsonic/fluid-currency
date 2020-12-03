import io.fluidsonic.gradle.*

plugins {
	id("io.fluidsonic.gradle") version "1.1.13"
}

fluidLibrary(name = "currency", version = "0.9.1")

fluidLibraryModule(description = "Kotlin multiplatform currency library") {
	targets {
		darwin()
		js()
		jvm()
	}
}
