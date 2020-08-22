package io.fluidsonic.currency

import java.util.Currency as PlatformCurrency


public fun PlatformCurrency.toCommon(): Currency =
	Currency.forCode(currencyCode)


public fun Currency.toPlatform(): PlatformCurrency =
	PlatformCurrency.getInstance(code.toString())
