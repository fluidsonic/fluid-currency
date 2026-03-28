# fluid-currency

Kotlin multiplatform ISO 4217 currency library. Targets JVM and JS.

## Build

Uses `io.fluidsonic.gradle` plugin with custom source layout:
- `sources/` — common main code
- `sources-jvm/` — JVM-specific code
- `tests/` — common tests
- `tests-jvm/` — JVM-specific tests

```
./gradlew build        # compile + test all targets
./gradlew jvmTest      # JVM tests only
./gradlew jsTest       # JS tests only
./gradlew allTests     # all tests
```

## Conventions

- Tags have no `v` prefix (e.g. `0.14.0`, not `v0.14.0`)
