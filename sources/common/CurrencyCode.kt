package io.fluidsonic.currency


/**
 * An ISO 4217 3-letter currency code, for example `EUR` or `USD`.
 *
 * References:
 * - [https://www.iso.org/iso-4217-currency-codes.html]
 * - [https://www.currency-iso.org/en/home/tables/table-a1.html]
 */
@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS", "UNUSED_PARAMETER")
public inline class CurrencyCode @PublishedApi internal constructor(private val value: String) {

	public fun isValid(): Boolean =
		Currency.forCodeOrNull(this) != null


	override fun toString(): String =
		value


	public companion object {

		public fun parse(string: String): CurrencyCode =
			parseOrNull(string) ?: error("Invalid ISO 4217 currency code format: $string")


		public fun parseOrNull(string: String): CurrencyCode? =
			string
				.takeIf(this::isValidFormat)
				?.let { CurrencyCode(value = it.toUpperCase()) }


		private fun isValidFormat(string: String) =
			string.length == 3 &&
				string[0].isLatinLetter() &&
				string[1].isLatinLetter() &&
				string[2].isLatinLetter()
	}
}
