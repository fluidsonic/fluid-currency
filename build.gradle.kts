plugins {
	alias(libs.plugins.kotlin.multiplatform)
	alias(libs.plugins.kotlin.serialization)
	alias(libs.plugins.dokka)
	alias(libs.plugins.gradle.nexus.publish)
	`maven-publish`
	signing
}

// Overridable so that a fork can publish under a Maven Central namespace it owns.
val publishGroup = providers.gradleProperty("publishGroup").getOrElse("io.fluidsonic.currency")
val publishNamespace = providers.gradleProperty("publishNamespace").getOrElse("io.fluidsonic")
val publishRepository = providers.gradleProperty("publishRepository").getOrElse("fluidsonic/fluid-currency")

group = publishGroup
version = "0.14.0"
description = "Kotlin multiplatform currency library"

repositories {
	mavenCentral()
}

kotlin {
	explicitApi()

	jvm {
		compilerOptions {
			jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_1_8)
		}
	}

	js {
		browser()
		nodejs()
	}

	@OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)
	wasmJs {
		browser()
		nodejs()
	}

	androidNativeArm32()
	androidNativeArm64()
	androidNativeX64()
	androidNativeX86()
	iosArm64()
	iosSimulatorArm64()
	iosX64()
	linuxArm64()
	linuxX64()
	macosArm64()
	mingwX64()
	tvosArm64()
	tvosSimulatorArm64()
	watchosArm32()
	watchosArm64()
	watchosDeviceArm64()
	watchosSimulatorArm64()

	sourceSets {
		commonMain.dependencies {
			implementation(libs.kotlinx.serialization.core)
		}
		commonTest.dependencies {
			implementation(kotlin("test"))
			implementation(libs.kotlinx.serialization.json)
		}
	}
}

val javadocJar = tasks.register<Jar>("javadocJar") {
	from(tasks.named("dokkaGeneratePublicationHtml"))
	archiveClassifier.set("javadoc")
}

publishing {
	val githubToken = System.getenv("GITHUB_PACKAGES_AUTH_TOKEN") ?: findProperty("GITHUB_PACKAGES_AUTH_TOKEN") as String?
	if (githubToken != null)
		repositories {
			maven {
				name = "github"
				setUrl("https://maven.pkg.github.com/$publishRepository")
				credentials {
					username = "unused"
					password = githubToken
				}
			}
		}

	publications.withType<MavenPublication>().configureEach {
		// Maven Central requires a javadoc jar in every publication. Only the JVM one gets Dokka output.
		if (name == "jvm")
			artifact(javadocJar)
		else
			artifact(tasks.register<Jar>("${name}JavadocJar") {
				archiveClassifier.set("javadoc")
				archiveAppendix.set(this@configureEach.name)
			})

		pom {
			name.set("fluid-currency")
			description.set(project.description)
			url.set("https://github.com/$publishRepository")
			developers {
				developer {
					id.set("fluidsonic")
					name.set("Marc Knaup")
					email.set("marc@knaup.io")
				}
			}
			licenses {
				license {
					name.set("Apache License 2.0")
					url.set("https://github.com/$publishRepository/blob/HEAD/LICENSE")
				}
			}
			scm {
				connection.set("scm:git:https://github.com/$publishRepository.git")
				developerConnection.set("scm:git:git@github.com:$publishRepository.git")
				url.set("https://github.com/$publishRepository")
			}
		}
	}
}

signing {
	val signingKey: String? = System.getenv("SIGNING_KEY")
	if (signingKey != null)
		useInMemoryPgpKeys(signingKey, System.getenv("SIGNING_PASSWORD"))

	sign(publishing.publications)
}

val sonatypeUsername: String? = System.getenv("SONATYPE_USERNAME")
val sonatypePassword: String? = System.getenv("SONATYPE_PASSWORD")
if (sonatypeUsername != null && sonatypePassword != null)
	nexusPublishing {
		packageGroup.set(publishNamespace)
		repositories {
			sonatype {
				username.set(sonatypeUsername)
				password.set(sonatypePassword)
				nexusUrl.set(uri("https://ossrh-staging-api.central.sonatype.com/service/local/"))
				snapshotRepositoryUrl.set(uri("https://central.sonatype.com/repository/maven-snapshots/"))
			}
		}
	}
