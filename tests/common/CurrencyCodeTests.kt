package tests

import io.fluidsonic.currency.*
import kotlin.test.*


class CurrencyCodeTests {

	@Test
	fun testEqualsAndHashCode() {
		assertEquals(expected = CurrencyCode.parse("EUR"), actual = CurrencyCode.parse("eur"))
		assertEquals(expected = CurrencyCode.parse("EUR").hashCode(), actual = CurrencyCode.parse("eur").hashCode())
	}


	@Test
	fun testIsValid() {
		assertTrue(CurrencyCode.parse("eur").isValid())
		assertFalse(CurrencyCode.parse("abc").isValid())
	}


	@Test
	fun testParseAndToString() {
		assertEquals(expected = "EUR", actual = CurrencyCode.parse("EUR").toString())
		assertEquals(expected = "ABC", actual = CurrencyCode.parse("abc").toString())

		assertEquals(
			expected = "Invalid ISO 4217 currency code format: ab1",
			actual = assertFails { CurrencyCode.parse("ab1") }.message
		)
	}
}
