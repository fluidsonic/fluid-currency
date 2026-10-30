package tests

import io.fluidsonic.currency.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlin.test.*


class CurrencyCodeTests {

	@Test
	fun testEqualsAndHashCode() {
		assertEquals(actual = CurrencyCode.parse("EUR"), expected = CurrencyCode.parse("eur"))
		assertEquals(actual = CurrencyCode.parse("EUR").hashCode(), expected = CurrencyCode.parse("eur").hashCode())
		assertEquals(actual = CurrencyCode.parse("Eur"), expected = CurrencyCode.parse("EUR"))
	}


	@Test
	fun testIsValid() {
		assertTrue(CurrencyCode.parse("EUR").isValid())
		assertTrue(CurrencyCode.parse("usd").isValid())
		assertFalse(CurrencyCode.parse("ABC").isValid())
		assertFalse(CurrencyCode.parse("zzz").isValid())
	}


	@Test
	fun testParseAndToString() {
		assertEquals(actual = CurrencyCode.parse("EUR").toString(), expected = "EUR")
		assertEquals(actual = CurrencyCode.parse("abc").toString(), expected = "ABC")
		assertEquals(actual = CurrencyCode.parse("eur").toString(), expected = "EUR")
		assertEquals(actual = CurrencyCode.parse("Eur").toString(), expected = "EUR")
	}


	@Test
	fun testParse_invalidFormat() {
		assertEquals(
			actual = assertFails { CurrencyCode.parse("ab1") }.message,
			expected = "Invalid ISO 4217 currency code format: ab1",
		)
		assertEquals(
			actual = assertFails { CurrencyCode.parse("") }.message,
			expected = "Invalid ISO 4217 currency code format: ",
		)
		assertEquals(
			actual = assertFails { CurrencyCode.parse("AB") }.message,
			expected = "Invalid ISO 4217 currency code format: AB",
		)
		assertEquals(
			actual = assertFails { CurrencyCode.parse("ABCD") }.message,
			expected = "Invalid ISO 4217 currency code format: ABCD",
		)
	}


	@Test
	fun testParseOrNull_validCodes() {
		assertNotNull(CurrencyCode.parseOrNull("EUR"))
		assertNotNull(CurrencyCode.parseOrNull("eur"))
		assertNotNull(CurrencyCode.parseOrNull("Abc"))
	}


	@Test
	fun testParseOrNull_invalidFormat() {
		assertNull(CurrencyCode.parseOrNull(""))
		assertNull(CurrencyCode.parseOrNull("A"))
		assertNull(CurrencyCode.parseOrNull("AB"))
		assertNull(CurrencyCode.parseOrNull("ABCD"))
		assertNull(CurrencyCode.parseOrNull("12A"))
		assertNull(CurrencyCode.parseOrNull("A1B"))
		assertNull(CurrencyCode.parseOrNull("AB1"))
		assertNull(CurrencyCode.parseOrNull("123"))
		assertNull(CurrencyCode.parseOrNull("A B"))
		assertNull(CurrencyCode.parseOrNull("AB!"))
	}


	@Test
	fun testToStringAlwaysUppercase() {
		assertEquals(actual = CurrencyCode.parse("abc").toString(), expected = "ABC")
		assertEquals(actual = CurrencyCode.parse("xyz").toString(), expected = "XYZ")
		assertEquals(actual = CurrencyCode.parse("aBc").toString(), expected = "ABC")
	}


	@Test
	fun testSerialization() {
		val code = CurrencyCode.parse("EUR")
		val json = Json.encodeToString(code)
		assertEquals(actual = json, expected = "\"EUR\"")

		val decoded = Json.decodeFromString<CurrencyCode>(json)
		assertEquals(actual = decoded, expected = code)
	}


	@Test
	fun testSerialization_invalidInput() {
		assertFailsWith<SerializationException> { Json.decodeFromString<CurrencyCode>("\"12A\"") }
		assertFailsWith<SerializationException> { Json.decodeFromString<CurrencyCode>("\"\"") }
	}
}
