package tests

import io.fluidsonic.currency.*
import kotlin.test.*


class CurrencyTests {

	@Test
	fun testEqualsAndHashCode() {
		assertEquals(actual = Currency.forCode("EUR"), expected = Currency.forCode("eur"))
		assertEquals(actual = Currency.forCode("EUR").hashCode(), expected = Currency.forCode("eur").hashCode())
	}


	@Test
	fun testForCode() {
		assertEquals(actual = Currency.forCode(CurrencyCode.parse("EUR")).code.toString(), expected = "EUR")
		assertNull(Currency.forCodeOrNull(CurrencyCode.parse("ABC")))

		assertEquals(
			actual = assertFails { Currency.forCode(CurrencyCode.parse("ABC")) }.message,
			expected = "Invalid ISO 4217 currency code: ABC",
		)
	}


	@Test
	fun testForCodeString() {
		assertEquals(actual = Currency.forCode("EUR").code.toString(), expected = "EUR")
		assertEquals(actual = Currency.forCode("eur").code.toString(), expected = "EUR")
		assertNull(Currency.forCodeOrNull("abc"))
		assertNull(Currency.forCodeOrNull("ab1"))

		assertEquals(
			actual = assertFails { Currency.forCode("abc") }.message,
			expected = "Invalid ISO 4217 currency code: ABC",
		)
		assertEquals(
			actual = assertFails { Currency.forCode("ab1") }.message,
			expected = "Invalid ISO 4217 currency code format: ab1",
		)
	}


	@Test
	fun testProperties_eur() {
		val eur = Currency.forCode("EUR")
		assertEquals(actual = eur.code, expected = CurrencyCode.parse("EUR"))
		assertEquals(actual = eur.defaultFractionDigits, expected = 2)
		assertEquals(actual = eur.numericCode, expected = 978)
	}


	@Test
	fun testProperties_usd() {
		val usd = Currency.forCode("USD")
		assertEquals(actual = usd.code, expected = CurrencyCode.parse("USD"))
		assertEquals(actual = usd.defaultFractionDigits, expected = 2)
		assertEquals(actual = usd.numericCode, expected = 840)
	}


	@Test
	fun testToString() {
		assertEquals(actual = Currency.forCode("eur").toString(), expected = "EUR")
	}


	@Test
	fun testAllCurrencies_uniqueCodes() {
		val codes = Currency.all.map { it.code }
		assertEquals(actual = codes.size, expected = codes.toSet().size)
	}


	@Test
	fun testAllCurrencies_uniqueNumericCodes() {
		val numericCodes = Currency.all.map { it.numericCode }
		assertEquals(actual = numericCodes.size, expected = numericCodes.toSet().size)
	}


	@Test
	fun testAllCurrencies_validCodeFormat() {
		for (currency in Currency.all) {
			assertEquals(
				actual = currency.code.toString().length,
				expected = 3,
			)
		}
	}


	@Test
	fun testZeroFractionDigits() {
		assertEquals(actual = Currency.forCode("JPY").defaultFractionDigits, expected = 0)
		assertEquals(actual = Currency.forCode("KRW").defaultFractionDigits, expected = 0)
		assertEquals(actual = Currency.forCode("VND").defaultFractionDigits, expected = 0)
	}


	@Test
	fun testThreeFractionDigits() {
		assertEquals(actual = Currency.forCode("BHD").defaultFractionDigits, expected = 3)
		assertEquals(actual = Currency.forCode("KWD").defaultFractionDigits, expected = 3)
		assertEquals(actual = Currency.forCode("OMR").defaultFractionDigits, expected = 3)
	}


	@Test
	fun testNegativeFractionDigits() {
		assertEquals(actual = Currency.forCode("XAU").defaultFractionDigits, expected = -1)
		assertEquals(actual = Currency.forCode("XAG").defaultFractionDigits, expected = -1)
		assertEquals(actual = Currency.forCode("XPT").defaultFractionDigits, expected = -1)
	}


	@Test
	fun testFourFractionDigits() {
		assertEquals(actual = Currency.forCode("CLF").defaultFractionDigits, expected = 4)
	}


	@Test
	fun testNewCurrencies() {
		val sle = Currency.forCode("SLE")
		assertEquals(actual = sle.defaultFractionDigits, expected = 2)
		assertEquals(actual = sle.numericCode, expected = 925)

		val ved = Currency.forCode("VED")
		assertEquals(actual = ved.defaultFractionDigits, expected = 2)
		assertEquals(actual = ved.numericCode, expected = 926)
	}


	@Test
	fun testForCodeOrNull_unknownValidFormat() {
		assertNull(Currency.forCodeOrNull("QQQ"))
		assertNull(Currency.forCodeOrNull("ZZZ"))
	}
}
