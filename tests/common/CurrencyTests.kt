package tests

import io.fluidsonic.currency.*
import kotlin.test.*


class CurrencyTests {

	@Test
	fun testEqualsAndHashCode() {
		assertEquals(expected = Currency.forCode("EUR"), actual = Currency.forCode("eur"))
		assertEquals(expected = Currency.forCode("EUR").hashCode(), actual = Currency.forCode("eur").hashCode())
	}


	@Test
	fun testForCode() {
		assertEquals(expected = "EUR", actual = Currency.forCode(CurrencyCode.parse("EUR")).code.toString())
		assertNull(Currency.forCodeOrNull(CurrencyCode.parse("ABC")))

		assertEquals(
			expected = "Invalid ISO 4217 currency code: ABC",
			actual = assertFails { Currency.forCode(CurrencyCode.parse("ABC")) }.message
		)
	}


	@Test
	fun testForCodeString() {
		assertEquals(expected = "EUR", actual = Currency.forCode("EUR").code.toString())
		assertEquals(expected = "EUR", actual = Currency.forCode("eur").code.toString())
		assertNull(Currency.forCodeOrNull("abc"))
		assertNull(Currency.forCodeOrNull("ab1"))

		assertEquals(
			expected = "Invalid ISO 4217 currency code: abc",
			actual = assertFails { Currency.forCode("abc") }.message
		)
		assertEquals(
			expected = "Invalid ISO 4217 currency code format: ab1",
			actual = assertFails { Currency.forCode("ab1") }.message
		)
	}


	@Test
	fun testProperties() {
		val eurCode = CurrencyCode.parse("EUR")
		val eur = Currency.forCode(eurCode)

		assertEquals(expected = eurCode, actual = eur.code)
		assertEquals(expected = 2, actual = eur.defaultFractionDigits)
		assertEquals(expected = 978, actual = eur.numericCode)
	}


	@Test
	fun testToString() {
		assertEquals(expected = "EUR", actual = Currency.forCode("eur").toString())
	}
}
