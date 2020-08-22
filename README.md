fluid-currency
==============

[![Maven Central](https://img.shields.io/maven-central/v/io.fluidsonic.currency/fluid-currency?label=Maven%20Central)](https://search.maven.org/artifact/io.fluidsonic.currency/fluid-currency)
[![JCenter](https://img.shields.io/bintray/v/fluidsonic/kotlin/currency?label=JCenter)](https://bintray.com/fluidsonic/kotlin/currency)
[![Tests](https://github.com/fluidsonic/fluid-currency/workflows/Tests/badge.svg)](https://github.com/fluidsonic/fluid-currency/actions?workflow=Tests)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.4.0%20(Darwin,%20JVM,%20JS)-blue.svg)](https://github.com/JetBrains/kotlin/releases/v1.4.0)
[![#fluid-libraries Slack Channel](https://img.shields.io/badge/slack-%23fluid--libraries-543951.svg?label=Slack)](https://kotlinlang.slack.com/messages/C7UDFSVT2/)

Kotlin multiplatform `Currency` support.



Installation
------------

`build.gradle.kts`:
```kotlin
dependencies {
    implementation("io.fluidsonic.currency:fluid-currency:0.9.0")
}
```



Usage
-----

```kotlin
println(Currency.fromCode("EUR").name) // 'Euro'
```

### `class Currency`

A class with information about a specific currency defined by [ISO 4217](https://www.currency-iso.org/en/home/tables/table-a1.html).

```kotlin
val currency = Currency.forCode("EUR") // throws if code is invalid (not defined by ISO 4217) or has an invalid format (not three latin letters)
println(currency.code) // EUR
println(currency.defaultFractionDigits) // 2
println(currency.name) // Euro
println(currency.numericCode) // 978
```

```kotlin
val currency = Currency.forCodeOrNull("ABC123") // null if code is invalid (not defined by ISO 4217) or has an invalid format (not three latin letters)
println(currency) // null
```

### `class CurrencyCode`

An inline class for ISO 4217 3-letter currency codes (e.g. `EUR` or `USD`).

```kotlin
val code = CurrencyCode.parse("EUR") // throws if code has invalid format (not three latin letters)
println(code.toString()) // EUR
println(code.isValid()) // true - 'EUR' is defined by ISO 4217
```

```kotlin
val code = CurrencyCode.parse("abc") // throws if code has invalid format (not three latin letters)
println(code.toString()) // ABC
println(code.isValid()) // false - 'ABC' is not defined by ISO 4217
```

```kotlin
val code = CurrencyCode.parseOrNull("ABC123") // null if code has invalid format (not three latin letters)
println(code) // null
```



License
-------

Apache 2.0
