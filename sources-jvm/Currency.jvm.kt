package io.fluidsonic.currency

import java.util.Currency as PlatformCurrency


/** Converts this [java.util.Currency] to the corresponding [Currency] from this library. */
public fun PlatformCurrency.toCommon(): Currency =
	Currency.forCode(currencyCode)


/** Converts this [Currency] to the corresponding [java.util.Currency]. */
public fun Currency.toPlatform(): PlatformCurrency =
	PlatformCurrency.getInstance(code.toString())
