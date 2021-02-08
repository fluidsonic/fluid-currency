import io.fluidsonic.gradle.*
import org.jetbrains.kotlin.gradle.plugin.*

plugins {
	id("io.fluidsonic.gradle") version "1.1.21"
}

fluidLibrary(name = "currency", version = "0.9.4")

fluidLibraryModule(description = "Kotlin multiplatform currency library") {
	targets {
		common {
			dependencies {
				implementation(kotlinx("serialization-core", "1.1.0-RC"))
			}
		}

		darwin {
			withoutWatchosX64() // https://github.com/Kotlin/kotlinx.serialization/pull/1285
		}
		js(KotlinJsCompilerType.BOTH)
		jvm()
	}
}
