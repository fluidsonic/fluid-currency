package tests

import io.fluidsonic.currency.*
import java.util.Currency as PlatformCurrency
import kotlin.test.*


class CurrencyJvmTests {

	@Test
	fun testToCommon() {
		val platformEur = PlatformCurrency.getInstance("EUR")
		val commonEur = platformEur.toCommon()
		assertEquals(actual = commonEur.code.toString(), expected = "EUR")
		assertEquals(actual = commonEur.defaultFractionDigits, expected = 2)
	}


	@Test
	fun testToPlatform() {
		val commonUsd = Currency.forCode("USD")
		val platformUsd = commonUsd.toPlatform()
		assertEquals(actual = platformUsd.currencyCode, expected = "USD")
	}


	@Test
	fun testRoundTrip() {
		val original = Currency.forCode("GBP")
		val roundTripped = original.toPlatform().toCommon()
		assertEquals(actual = roundTripped, expected = original)
		assertEquals(actual = roundTripped.code, expected = original.code)
	}
}
