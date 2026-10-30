# fluid-currency

Kotlin multiplatform ISO 4217 currency library. Targets JVM, JS, Wasm (wasmJs) and Kotlin/Native (Android Native, iOS, Linux, macOS, tvOS, watchOS, Windows).

## Build

Plain Kotlin Multiplatform Gradle build (`build.gradle.kts`), dependency versions in `gradle/libs.versions.toml`.
Standard source layout:
- `src/commonMain/kotlin/` — common main code
- `src/jvmMain/kotlin/` — JVM-specific code
- `src/commonTest/kotlin/` — common tests
- `src/jvmTest/kotlin/` — JVM-specific tests

```
./gradlew build        # compile + test all targets
./gradlew jvmTest      # JVM tests only
./gradlew jsTest       # JS tests only
./gradlew wasmJsTest   # Wasm tests only
./gradlew linuxX64Test # Native tests on Linux (Apple tests need macOS, mingwX64 needs Windows)
./gradlew allTests     # all tests
```

## Releasing

Push a tag matching the version in `build.gradle.kts` (e.g. `0.15.0`). `.github/workflows/release.yml` builds on macOS
and publishes to Maven Central through Sonatype's OSSRH Staging API. Secrets: `SONATYPE_USERNAME`/`SONATYPE_PASSWORD`
(Central Portal user token), `SIGNING_KEY`/`SIGNING_PASSWORD` (armored PGP key). A fork publishes under its own namespace
by setting the repository variables `PUBLISH_GROUP` and `PUBLISH_NAMESPACE`; POM URLs follow the repository it runs in.

## Conventions

- Tags have no `v` prefix (e.g. `0.14.0`, not `v0.14.0`)
