package io.fluidsonic.currency


public class Currency private constructor(
	public val code: CurrencyCode,
	public val defaultFractionDigits: Int,
	public val numericCode: Int,
) {

	init {
		freeze()
	}


	override fun toString(): String =
		code.toString()


	public companion object {

		// https://www.currency-iso.org/en/home/tables/table-a1.html
		public val all: Set<Currency> = hashSetOf(
			make(code = "AED", defaultFractionDigits = 2, numericCode = 784),
			make(code = "AFN", defaultFractionDigits = 2, numericCode = 971),
			make(code = "ALL", defaultFractionDigits = 2, numericCode = 8),
			make(code = "AMD", defaultFractionDigits = 2, numericCode = 51),
			make(code = "ANG", defaultFractionDigits = 2, numericCode = 532),
			make(code = "AOA", defaultFractionDigits = 2, numericCode = 973),
			make(code = "ARS", defaultFractionDigits = 2, numericCode = 32),
			make(code = "AUD", defaultFractionDigits = 2, numericCode = 36),
			make(code = "AWG", defaultFractionDigits = 2, numericCode = 533),
			make(code = "AZN", defaultFractionDigits = 2, numericCode = 944),
			make(code = "BAM", defaultFractionDigits = 2, numericCode = 977),
			make(code = "BBD", defaultFractionDigits = 2, numericCode = 52),
			make(code = "BDT", defaultFractionDigits = 2, numericCode = 50),
			make(code = "BGN", defaultFractionDigits = 2, numericCode = 975),
			make(code = "BHD", defaultFractionDigits = 3, numericCode = 48),
			make(code = "BIF", defaultFractionDigits = 0, numericCode = 108),
			make(code = "BMD", defaultFractionDigits = 2, numericCode = 60),
			make(code = "BND", defaultFractionDigits = 2, numericCode = 96),
			make(code = "BOB", defaultFractionDigits = 2, numericCode = 68),
			make(code = "BOV", defaultFractionDigits = 2, numericCode = 984),
			make(code = "BRL", defaultFractionDigits = 2, numericCode = 986),
			make(code = "BSD", defaultFractionDigits = 2, numericCode = 44),
			make(code = "BTN", defaultFractionDigits = 2, numericCode = 64),
			make(code = "BWP", defaultFractionDigits = 2, numericCode = 72),
			make(code = "BYN", defaultFractionDigits = 2, numericCode = 933),
			make(code = "BZD", defaultFractionDigits = 2, numericCode = 84),
			make(code = "CAD", defaultFractionDigits = 2, numericCode = 124),
			make(code = "CDF", defaultFractionDigits = 2, numericCode = 976),
			make(code = "CHE", defaultFractionDigits = 2, numericCode = 947),
			make(code = "CHF", defaultFractionDigits = 2, numericCode = 756),
			make(code = "CHW", defaultFractionDigits = 2, numericCode = 948),
			make(code = "CLF", defaultFractionDigits = 4, numericCode = 990),
			make(code = "CLP", defaultFractionDigits = 0, numericCode = 152),
			make(code = "CNY", defaultFractionDigits = 2, numericCode = 156),
			make(code = "COP", defaultFractionDigits = 2, numericCode = 170),
			make(code = "COU", defaultFractionDigits = 2, numericCode = 970),
			make(code = "CRC", defaultFractionDigits = 2, numericCode = 188),
			make(code = "CUC", defaultFractionDigits = 2, numericCode = 931),
			make(code = "CUP", defaultFractionDigits = 2, numericCode = 192),
			make(code = "CVE", defaultFractionDigits = 2, numericCode = 132),
			make(code = "CZK", defaultFractionDigits = 2, numericCode = 203),
			make(code = "DJF", defaultFractionDigits = 0, numericCode = 262),
			make(code = "DKK", defaultFractionDigits = 2, numericCode = 208),
			make(code = "DOP", defaultFractionDigits = 2, numericCode = 214),
			make(code = "DZD", defaultFractionDigits = 2, numericCode = 12),
			make(code = "EGP", defaultFractionDigits = 2, numericCode = 818),
			make(code = "ERN", defaultFractionDigits = 2, numericCode = 232),
			make(code = "ETB", defaultFractionDigits = 2, numericCode = 230),
			make(code = "EUR", defaultFractionDigits = 2, numericCode = 978),
			make(code = "FJD", defaultFractionDigits = 2, numericCode = 242),
			make(code = "FKP", defaultFractionDigits = 2, numericCode = 238),
			make(code = "GBP", defaultFractionDigits = 2, numericCode = 826),
			make(code = "GEL", defaultFractionDigits = 2, numericCode = 981),
			make(code = "GHS", defaultFractionDigits = 2, numericCode = 936),
			make(code = "GIP", defaultFractionDigits = 2, numericCode = 292),
			make(code = "GMD", defaultFractionDigits = 2, numericCode = 270),
			make(code = "GNF", defaultFractionDigits = 0, numericCode = 324),
			make(code = "GTQ", defaultFractionDigits = 2, numericCode = 320),
			make(code = "GYD", defaultFractionDigits = 2, numericCode = 328),
			make(code = "HKD", defaultFractionDigits = 2, numericCode = 344),
			make(code = "HNL", defaultFractionDigits = 2, numericCode = 340),
			make(code = "HRK", defaultFractionDigits = 2, numericCode = 191),
			make(code = "HTG", defaultFractionDigits = 2, numericCode = 332),
			make(code = "HUF", defaultFractionDigits = 2, numericCode = 348),
			make(code = "IDR", defaultFractionDigits = 2, numericCode = 360),
			make(code = "ILS", defaultFractionDigits = 2, numericCode = 376),
			make(code = "INR", defaultFractionDigits = 2, numericCode = 356),
			make(code = "IQD", defaultFractionDigits = 3, numericCode = 368),
			make(code = "IRR", defaultFractionDigits = 2, numericCode = 364),
			make(code = "ISK", defaultFractionDigits = 0, numericCode = 352),
			make(code = "JMD", defaultFractionDigits = 2, numericCode = 388),
			make(code = "JOD", defaultFractionDigits = 3, numericCode = 400),
			make(code = "JPY", defaultFractionDigits = 0, numericCode = 392),
			make(code = "KES", defaultFractionDigits = 2, numericCode = 404),
			make(code = "KGS", defaultFractionDigits = 2, numericCode = 417),
			make(code = "KHR", defaultFractionDigits = 2, numericCode = 116),
			make(code = "KMF", defaultFractionDigits = 0, numericCode = 174),
			make(code = "KPW", defaultFractionDigits = 2, numericCode = 408),
			make(code = "KRW", defaultFractionDigits = 0, numericCode = 410),
			make(code = "KWD", defaultFractionDigits = 3, numericCode = 414),
			make(code = "KYD", defaultFractionDigits = 2, numericCode = 136),
			make(code = "KZT", defaultFractionDigits = 2, numericCode = 398),
			make(code = "LAK", defaultFractionDigits = 2, numericCode = 418),
			make(code = "LBP", defaultFractionDigits = 2, numericCode = 422),
			make(code = "LKR", defaultFractionDigits = 2, numericCode = 144),
			make(code = "LRD", defaultFractionDigits = 2, numericCode = 430),
			make(code = "LSL", defaultFractionDigits = 2, numericCode = 426),
			make(code = "LYD", defaultFractionDigits = 3, numericCode = 434),
			make(code = "MAD", defaultFractionDigits = 2, numericCode = 504),
			make(code = "MDL", defaultFractionDigits = 2, numericCode = 498),
			make(code = "MGA", defaultFractionDigits = 2, numericCode = 969),
			make(code = "MKD", defaultFractionDigits = 2, numericCode = 807),
			make(code = "MMK", defaultFractionDigits = 2, numericCode = 104),
			make(code = "MNT", defaultFractionDigits = 2, numericCode = 496),
			make(code = "MOP", defaultFractionDigits = 2, numericCode = 446),
			make(code = "MRU", defaultFractionDigits = 2, numericCode = 929),
			make(code = "MUR", defaultFractionDigits = 2, numericCode = 480),
			make(code = "MVR", defaultFractionDigits = 2, numericCode = 462),
			make(code = "MWK", defaultFractionDigits = 2, numericCode = 454),
			make(code = "MXN", defaultFractionDigits = 2, numericCode = 484),
			make(code = "MXV", defaultFractionDigits = 2, numericCode = 979),
			make(code = "MYR", defaultFractionDigits = 2, numericCode = 458),
			make(code = "MZN", defaultFractionDigits = 2, numericCode = 943),
			make(code = "NAD", defaultFractionDigits = 2, numericCode = 516),
			make(code = "NGN", defaultFractionDigits = 2, numericCode = 566),
			make(code = "NIO", defaultFractionDigits = 2, numericCode = 558),
			make(code = "NOK", defaultFractionDigits = 2, numericCode = 578),
			make(code = "NPR", defaultFractionDigits = 2, numericCode = 524),
			make(code = "NZD", defaultFractionDigits = 2, numericCode = 554),
			make(code = "OMR", defaultFractionDigits = 3, numericCode = 512),
			make(code = "PAB", defaultFractionDigits = 2, numericCode = 590),
			make(code = "PEN", defaultFractionDigits = 2, numericCode = 604),
			make(code = "PGK", defaultFractionDigits = 2, numericCode = 598),
			make(code = "PHP", defaultFractionDigits = 2, numericCode = 608),
			make(code = "PKR", defaultFractionDigits = 2, numericCode = 586),
			make(code = "PLN", defaultFractionDigits = 2, numericCode = 985),
			make(code = "PYG", defaultFractionDigits = 0, numericCode = 600),
			make(code = "QAR", defaultFractionDigits = 2, numericCode = 634),
			make(code = "RON", defaultFractionDigits = 2, numericCode = 946),
			make(code = "RSD", defaultFractionDigits = 2, numericCode = 941),
			make(code = "RUB", defaultFractionDigits = 2, numericCode = 643),
			make(code = "RWF", defaultFractionDigits = 0, numericCode = 646),
			make(code = "SAR", defaultFractionDigits = 2, numericCode = 682),
			make(code = "SBD", defaultFractionDigits = 2, numericCode = 90),
			make(code = "SCR", defaultFractionDigits = 2, numericCode = 690),
			make(code = "SDG", defaultFractionDigits = 2, numericCode = 938),
			make(code = "SEK", defaultFractionDigits = 2, numericCode = 752),
			make(code = "SGD", defaultFractionDigits = 2, numericCode = 702),
			make(code = "SHP", defaultFractionDigits = 2, numericCode = 654),
			make(code = "SLL", defaultFractionDigits = 2, numericCode = 694),
			make(code = "SOS", defaultFractionDigits = 2, numericCode = 706),
			make(code = "SRD", defaultFractionDigits = 2, numericCode = 968),
			make(code = "SSP", defaultFractionDigits = 2, numericCode = 728),
			make(code = "STN", defaultFractionDigits = 2, numericCode = 930),
			make(code = "SVC", defaultFractionDigits = 2, numericCode = 222),
			make(code = "SYP", defaultFractionDigits = 2, numericCode = 760),
			make(code = "SZL", defaultFractionDigits = 2, numericCode = 748),
			make(code = "THB", defaultFractionDigits = 2, numericCode = 764),
			make(code = "TJS", defaultFractionDigits = 2, numericCode = 972),
			make(code = "TMT", defaultFractionDigits = 2, numericCode = 934),
			make(code = "TND", defaultFractionDigits = 3, numericCode = 788),
			make(code = "TOP", defaultFractionDigits = 2, numericCode = 776),
			make(code = "TRY", defaultFractionDigits = 2, numericCode = 949),
			make(code = "TTD", defaultFractionDigits = 2, numericCode = 780),
			make(code = "TWD", defaultFractionDigits = 2, numericCode = 901),
			make(code = "TZS", defaultFractionDigits = 2, numericCode = 834),
			make(code = "UAH", defaultFractionDigits = 2, numericCode = 980),
			make(code = "UGX", defaultFractionDigits = 0, numericCode = 800),
			make(code = "USD", defaultFractionDigits = 2, numericCode = 840),
			make(code = "USN", defaultFractionDigits = 2, numericCode = 997),
			make(code = "UYI", defaultFractionDigits = 0, numericCode = 940),
			make(code = "UYU", defaultFractionDigits = 2, numericCode = 858),
			make(code = "UYW", defaultFractionDigits = 4, numericCode = 927),
			make(code = "UZS", defaultFractionDigits = 2, numericCode = 860),
			make(code = "VES", defaultFractionDigits = 2, numericCode = 928),
			make(code = "VND", defaultFractionDigits = 0, numericCode = 704),
			make(code = "VUV", defaultFractionDigits = 0, numericCode = 548),
			make(code = "WST", defaultFractionDigits = 2, numericCode = 882),
			make(code = "XAF", defaultFractionDigits = 0, numericCode = 950),
			make(code = "XAG", defaultFractionDigits = -1, numericCode = 961),
			make(code = "XAU", defaultFractionDigits = -1, numericCode = 959),
			make(code = "XBA", defaultFractionDigits = -1, numericCode = 955),
			make(code = "XBB", defaultFractionDigits = -1, numericCode = 956),
			make(code = "XBC", defaultFractionDigits = -1, numericCode = 957),
			make(code = "XBD", defaultFractionDigits = -1, numericCode = 958),
			make(code = "XCD", defaultFractionDigits = 2, numericCode = 951),
			make(code = "XDR", defaultFractionDigits = -1, numericCode = 960),
			make(code = "XOF", defaultFractionDigits = 0, numericCode = 952),
			make(code = "XPD", defaultFractionDigits = -1, numericCode = 964),
			make(code = "XPF", defaultFractionDigits = 0, numericCode = 953),
			make(code = "XPT", defaultFractionDigits = -1, numericCode = 962),
			make(code = "XSU", defaultFractionDigits = -1, numericCode = 994),
			make(code = "XTS", defaultFractionDigits = -1, numericCode = 963),
			make(code = "XUA", defaultFractionDigits = -1, numericCode = 965),
			make(code = "XXX", defaultFractionDigits = -1, numericCode = 999),
			make(code = "YER", defaultFractionDigits = 2, numericCode = 886),
			make(code = "ZAR", defaultFractionDigits = 2, numericCode = 710),
			make(code = "ZMW", defaultFractionDigits = 2, numericCode = 967),
			make(code = "ZWL", defaultFractionDigits = 2, numericCode = 932),
		)


		private val allByCode: Map<CurrencyCode, Currency> = all.associateByTo(hashMapOf()) { it.code }


		private fun make(code: String, defaultFractionDigits: Int, numericCode: Int): Currency =
			Currency(
				code = CurrencyCode(code),
				defaultFractionDigits = defaultFractionDigits,
				numericCode = numericCode
			)


		public fun forCode(code: CurrencyCode): Currency =
			forCodeOrNull(code) ?: error("Invalid ISO 4217 currency code: $code")


		public fun forCodeOrNull(code: CurrencyCode): Currency? =
			allByCode[code]


		public fun forCode(code: String): Currency =
			forCodeOrNull(CurrencyCode.parse(code)) ?: error("Invalid ISO 4217 currency code: $code")


		public fun forCodeOrNull(code: String): Currency? =
			CurrencyCode.parseOrNull(code)?.let(::forCodeOrNull)
	}
}
