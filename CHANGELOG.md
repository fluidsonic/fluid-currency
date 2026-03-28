# Changelog

## [0.14.0] - 2026-03-28

### Added

- New ISO 4217 currencies: SLE (Sierra Leonean Leone, 925) and VED (Venezuelan Digital Bolivar, 926)
- Comprehensive test suite: 75 tests across JVM and JS targets (up from 8)
- JVM interop tests for `toCommon()` and `toPlatform()` extensions
- Serialization round-trip tests using kotlinx-serialization-json
- KDoc documentation on public API and internal utilities
- JVM interop section in README
- Last-verified date comment on the ISO 4217 currency list

### Changed

- Upgraded to fluid-gradle 3.0.0 (Kotlin 2.3.20, Gradle 9.4.1, JDK 21)
- Updated kotlinx-serialization-core from 1.5.1 to 1.10.0
- Converted `CurrencyCode` from class to `value class` for zero-allocation overhead
- Added explicit `equals()`/`hashCode()` to `Currency` based on currency code
- Modernized GitHub Actions CI (checkout v6, setup-java v5, setup-gradle v6, JDK 21)
- Updated README with current Kotlin version, corrected API examples, and documented serialization support

### Deprecated

- `Currency.HRK` — Croatian Kuna was withdrawn from ISO 4217 when Croatia adopted EUR (2023-01-01)
- `Currency.SLL` — Old Sierra Leonean Leone, redenominated and replaced by SLE in 2022

### Fixed

- `CurrencyCodeSerializer` now throws `SerializationException` instead of `IllegalStateException` on invalid input
- `Currency.forCode(String)` error messages now consistently show uppercase currency codes

### Removed

- Darwin/Native targets (no longer supported by fluid-gradle 3.0.0)
