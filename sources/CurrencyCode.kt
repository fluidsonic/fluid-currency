package io.fluidsonic.currency

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*


/**
 * An ISO 4217 3-letter currency code, for example `EUR` or `USD`.
 *
 * References:
 * - [https://www.iso.org/iso-4217-currency-codes.html]
 * - [https://www.currency-iso.org/en/home/tables/table-a1.html]
 */
@Serializable(CurrencyCodeSerializer::class)
public class CurrencyCode internal constructor(private val value: String) {

	init {
		freeze()
	}


	override fun equals(other: Any?): Boolean =
		this === other || (other is CurrencyCode && value == other.value)


	override fun hashCode(): Int =
		value.hashCode()


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
				?.let { CurrencyCode(value = it.uppercase()) }


		private fun isValidFormat(string: String) =
			string.length == 3 &&
				string[0].isLatinLetter() &&
				string[1].isLatinLetter() &&
				string[2].isLatinLetter()
	}
}


@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = CurrencyCode::class)
internal object CurrencyCodeSerializer : KSerializer<CurrencyCode> {

	override val descriptor: SerialDescriptor =
		PrimitiveSerialDescriptor("io.fluidsonic.currency.CurrencyCode", PrimitiveKind.STRING)


	override fun serialize(encoder: Encoder, value: CurrencyCode) {
		encoder.encodeString(value.toString())
	}


	override fun deserialize(decoder: Decoder): CurrencyCode =
		CurrencyCode.parse(decoder.decodeString())
}
