package io.fluidsonic.currency


public class Currency private constructor(
	public val code: CurrencyCode,
	public val defaultFractionDigits: Int,
	public val name: String,
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
			make(code = "AED", defaultFractionDigits = 2, numericCode = 784, name = "UAE Dirham"),
			make(code = "AFN", defaultFractionDigits = 2, numericCode = 971, name = "Afghani"),
			make(code = "ALL", defaultFractionDigits = 2, numericCode = 8, name = "Lek"),
			make(code = "AMD", defaultFractionDigits = 2, numericCode = 51, name = "Armenian Dram"),
			make(code = "ANG", defaultFractionDigits = 2, numericCode = 532, name = "Netherlands Antillean Guilder"),
			make(code = "AOA", defaultFractionDigits = 2, numericCode = 973, name = "Kwanza"),
			make(code = "ARS", defaultFractionDigits = 2, numericCode = 32, name = "Argentine Peso"),
			make(code = "AUD", defaultFractionDigits = 2, numericCode = 36, name = "Australian Dollar"),
			make(code = "AWG", defaultFractionDigits = 2, numericCode = 533, name = "Aruban Florin"),
			make(code = "AZN", defaultFractionDigits = 2, numericCode = 944, name = "Azerbaijan Manat"),
			make(code = "BAM", defaultFractionDigits = 2, numericCode = 977, name = "Convertible Mark"),
			make(code = "BBD", defaultFractionDigits = 2, numericCode = 52, name = "Barbados Dollar"),
			make(code = "BDT", defaultFractionDigits = 2, numericCode = 50, name = "Taka"),
			make(code = "BGN", defaultFractionDigits = 2, numericCode = 975, name = "Bulgarian Lev"),
			make(code = "BHD", defaultFractionDigits = 3, numericCode = 48, name = "Bahraini Dinar"),
			make(code = "BIF", defaultFractionDigits = 0, numericCode = 108, name = "Burundi Franc"),
			make(code = "BMD", defaultFractionDigits = 2, numericCode = 60, name = "Bermudian Dollar"),
			make(code = "BND", defaultFractionDigits = 2, numericCode = 96, name = "Brunei Dollar"),
			make(code = "BOB", defaultFractionDigits = 2, numericCode = 68, name = "Boliviano"),
			make(code = "BOV", defaultFractionDigits = 2, numericCode = 984, name = "Mvdol"),
			make(code = "BRL", defaultFractionDigits = 2, numericCode = 986, name = "Brazilian Real"),
			make(code = "BSD", defaultFractionDigits = 2, numericCode = 44, name = "Bahamian Dollar"),
			make(code = "BTN", defaultFractionDigits = 2, numericCode = 64, name = "Ngultrum"),
			make(code = "BWP", defaultFractionDigits = 2, numericCode = 72, name = "Pula"),
			make(code = "BYN", defaultFractionDigits = 2, numericCode = 933, name = "Belarusian Ruble"),
			make(code = "BZD", defaultFractionDigits = 2, numericCode = 84, name = "Belize Dollar"),
			make(code = "CAD", defaultFractionDigits = 2, numericCode = 124, name = "Canadian Dollar"),
			make(code = "CDF", defaultFractionDigits = 2, numericCode = 976, name = "Congolese Franc"),
			make(code = "CHE", defaultFractionDigits = 2, numericCode = 947, name = "WIR Euro"),
			make(code = "CHF", defaultFractionDigits = 2, numericCode = 756, name = "Swiss Franc"),
			make(code = "CHW", defaultFractionDigits = 2, numericCode = 948, name = "WIR Franc"),
			make(code = "CLF", defaultFractionDigits = 4, numericCode = 990, name = "Unidad de Fomento"),
			make(code = "CLP", defaultFractionDigits = 0, numericCode = 152, name = "Chilean Peso"),
			make(code = "CNY", defaultFractionDigits = 2, numericCode = 156, name = "Yuan Renminbi"),
			make(code = "COP", defaultFractionDigits = 2, numericCode = 170, name = "Colombian Peso"),
			make(code = "COU", defaultFractionDigits = 2, numericCode = 970, name = "Unidad de Valor Real"),
			make(code = "CRC", defaultFractionDigits = 2, numericCode = 188, name = "Costa Rican Colon"),
			make(code = "CUC", defaultFractionDigits = 2, numericCode = 931, name = "Peso Convertible"),
			make(code = "CUP", defaultFractionDigits = 2, numericCode = 192, name = "Cuban Peso"),
			make(code = "CVE", defaultFractionDigits = 2, numericCode = 132, name = "Cabo Verde Escudo"),
			make(code = "CZK", defaultFractionDigits = 2, numericCode = 203, name = "Czech Koruna"),
			make(code = "DJF", defaultFractionDigits = 0, numericCode = 262, name = "Djibouti Franc"),
			make(code = "DKK", defaultFractionDigits = 2, numericCode = 208, name = "Danish Krone"),
			make(code = "DOP", defaultFractionDigits = 2, numericCode = 214, name = "Dominican Peso"),
			make(code = "DZD", defaultFractionDigits = 2, numericCode = 12, name = "Algerian Dinar"),
			make(code = "EGP", defaultFractionDigits = 2, numericCode = 818, name = "Egyptian Pound"),
			make(code = "ERN", defaultFractionDigits = 2, numericCode = 232, name = "Nakfa"),
			make(code = "ETB", defaultFractionDigits = 2, numericCode = 230, name = "Ethiopian Birr"),
			make(code = "EUR", defaultFractionDigits = 2, numericCode = 978, name = "Euro"),
			make(code = "FJD", defaultFractionDigits = 2, numericCode = 242, name = "Fiji Dollar"),
			make(code = "FKP", defaultFractionDigits = 2, numericCode = 238, name = "Falkland Islands Pound"),
			make(code = "GBP", defaultFractionDigits = 2, numericCode = 826, name = "Pound Sterling"),
			make(code = "GEL", defaultFractionDigits = 2, numericCode = 981, name = "Lari"),
			make(code = "GHS", defaultFractionDigits = 2, numericCode = 936, name = "Ghana Cedi"),
			make(code = "GIP", defaultFractionDigits = 2, numericCode = 292, name = "Gibraltar Pound"),
			make(code = "GMD", defaultFractionDigits = 2, numericCode = 270, name = "Dalasi"),
			make(code = "GNF", defaultFractionDigits = 0, numericCode = 324, name = "Guinean Franc"),
			make(code = "GTQ", defaultFractionDigits = 2, numericCode = 320, name = "Quetzal"),
			make(code = "GYD", defaultFractionDigits = 2, numericCode = 328, name = "Guyana Dollar"),
			make(code = "HKD", defaultFractionDigits = 2, numericCode = 344, name = "Hong Kong Dollar"),
			make(code = "HNL", defaultFractionDigits = 2, numericCode = 340, name = "Lempira"),
			make(code = "HRK", defaultFractionDigits = 2, numericCode = 191, name = "Kuna"),
			make(code = "HTG", defaultFractionDigits = 2, numericCode = 332, name = "Gourde"),
			make(code = "HUF", defaultFractionDigits = 2, numericCode = 348, name = "Forint"),
			make(code = "IDR", defaultFractionDigits = 2, numericCode = 360, name = "Rupiah"),
			make(code = "ILS", defaultFractionDigits = 2, numericCode = 376, name = "New Israeli Sheqel"),
			make(code = "INR", defaultFractionDigits = 2, numericCode = 356, name = "Indian Rupee"),
			make(code = "IQD", defaultFractionDigits = 3, numericCode = 368, name = "Iraqi Dinar"),
			make(code = "IRR", defaultFractionDigits = 2, numericCode = 364, name = "Iranian Rial"),
			make(code = "ISK", defaultFractionDigits = 0, numericCode = 352, name = "Iceland Krona"),
			make(code = "JMD", defaultFractionDigits = 2, numericCode = 388, name = "Jamaican Dollar"),
			make(code = "JOD", defaultFractionDigits = 3, numericCode = 400, name = "Jordanian Dinar"),
			make(code = "JPY", defaultFractionDigits = 0, numericCode = 392, name = "Yen"),
			make(code = "KES", defaultFractionDigits = 2, numericCode = 404, name = "Kenyan Shilling"),
			make(code = "KGS", defaultFractionDigits = 2, numericCode = 417, name = "Som"),
			make(code = "KHR", defaultFractionDigits = 2, numericCode = 116, name = "Riel"),
			make(code = "KMF", defaultFractionDigits = 0, numericCode = 174, name = "Comorian Franc "),
			make(code = "KPW", defaultFractionDigits = 2, numericCode = 408, name = "North Korean Won"),
			make(code = "KRW", defaultFractionDigits = 0, numericCode = 410, name = "Won"),
			make(code = "KWD", defaultFractionDigits = 3, numericCode = 414, name = "Kuwaiti Dinar"),
			make(code = "KYD", defaultFractionDigits = 2, numericCode = 136, name = "Cayman Islands Dollar"),
			make(code = "KZT", defaultFractionDigits = 2, numericCode = 398, name = "Tenge"),
			make(code = "LAK", defaultFractionDigits = 2, numericCode = 418, name = "Lao Kip"),
			make(code = "LBP", defaultFractionDigits = 2, numericCode = 422, name = "Lebanese Pound"),
			make(code = "LKR", defaultFractionDigits = 2, numericCode = 144, name = "Sri Lanka Rupee"),
			make(code = "LRD", defaultFractionDigits = 2, numericCode = 430, name = "Liberian Dollar"),
			make(code = "LSL", defaultFractionDigits = 2, numericCode = 426, name = "Loti"),
			make(code = "LYD", defaultFractionDigits = 3, numericCode = 434, name = "Libyan Dinar"),
			make(code = "MAD", defaultFractionDigits = 2, numericCode = 504, name = "Moroccan Dirham"),
			make(code = "MDL", defaultFractionDigits = 2, numericCode = 498, name = "Moldovan Leu"),
			make(code = "MGA", defaultFractionDigits = 2, numericCode = 969, name = "Malagasy Ariary"),
			make(code = "MKD", defaultFractionDigits = 2, numericCode = 807, name = "Denar"),
			make(code = "MMK", defaultFractionDigits = 2, numericCode = 104, name = "Kyat"),
			make(code = "MNT", defaultFractionDigits = 2, numericCode = 496, name = "Tugrik"),
			make(code = "MOP", defaultFractionDigits = 2, numericCode = 446, name = "Pataca"),
			make(code = "MRU", defaultFractionDigits = 2, numericCode = 929, name = "Ouguiya"),
			make(code = "MUR", defaultFractionDigits = 2, numericCode = 480, name = "Mauritius Rupee"),
			make(code = "MVR", defaultFractionDigits = 2, numericCode = 462, name = "Rufiyaa"),
			make(code = "MWK", defaultFractionDigits = 2, numericCode = 454, name = "Malawi Kwacha"),
			make(code = "MXN", defaultFractionDigits = 2, numericCode = 484, name = "Mexican Peso"),
			make(code = "MXV", defaultFractionDigits = 2, numericCode = 979, name = "Mexican Unidad de Inversion (UDI)"),
			make(code = "MYR", defaultFractionDigits = 2, numericCode = 458, name = "Malaysian Ringgit"),
			make(code = "MZN", defaultFractionDigits = 2, numericCode = 943, name = "Mozambique Metical"),
			make(code = "NAD", defaultFractionDigits = 2, numericCode = 516, name = "Namibia Dollar"),
			make(code = "NGN", defaultFractionDigits = 2, numericCode = 566, name = "Naira"),
			make(code = "NIO", defaultFractionDigits = 2, numericCode = 558, name = "Cordoba Oro"),
			make(code = "NOK", defaultFractionDigits = 2, numericCode = 578, name = "Norwegian Krone"),
			make(code = "NPR", defaultFractionDigits = 2, numericCode = 524, name = "Nepalese Rupee"),
			make(code = "NZD", defaultFractionDigits = 2, numericCode = 554, name = "New Zealand Dollar"),
			make(code = "OMR", defaultFractionDigits = 3, numericCode = 512, name = "Rial Omani"),
			make(code = "PAB", defaultFractionDigits = 2, numericCode = 590, name = "Balboa"),
			make(code = "PEN", defaultFractionDigits = 2, numericCode = 604, name = "Sol"),
			make(code = "PGK", defaultFractionDigits = 2, numericCode = 598, name = "Kina"),
			make(code = "PHP", defaultFractionDigits = 2, numericCode = 608, name = "Philippine Peso"),
			make(code = "PKR", defaultFractionDigits = 2, numericCode = 586, name = "Pakistan Rupee"),
			make(code = "PLN", defaultFractionDigits = 2, numericCode = 985, name = "Zloty"),
			make(code = "PYG", defaultFractionDigits = 0, numericCode = 600, name = "Guarani"),
			make(code = "QAR", defaultFractionDigits = 2, numericCode = 634, name = "Qatari Rial"),
			make(code = "RON", defaultFractionDigits = 2, numericCode = 946, name = "Romanian Leu"),
			make(code = "RSD", defaultFractionDigits = 2, numericCode = 941, name = "Serbian Dinar"),
			make(code = "RUB", defaultFractionDigits = 2, numericCode = 643, name = "Russian Ruble"),
			make(code = "RWF", defaultFractionDigits = 0, numericCode = 646, name = "Rwanda Franc"),
			make(code = "SAR", defaultFractionDigits = 2, numericCode = 682, name = "Saudi Riyal"),
			make(code = "SBD", defaultFractionDigits = 2, numericCode = 90, name = "Solomon Islands Dollar"),
			make(code = "SCR", defaultFractionDigits = 2, numericCode = 690, name = "Seychelles Rupee"),
			make(code = "SDG", defaultFractionDigits = 2, numericCode = 938, name = "Sudanese Pound"),
			make(code = "SEK", defaultFractionDigits = 2, numericCode = 752, name = "Swedish Krona"),
			make(code = "SGD", defaultFractionDigits = 2, numericCode = 702, name = "Singapore Dollar"),
			make(code = "SHP", defaultFractionDigits = 2, numericCode = 654, name = "Saint Helena Pound"),
			make(code = "SLL", defaultFractionDigits = 2, numericCode = 694, name = "Leone"),
			make(code = "SOS", defaultFractionDigits = 2, numericCode = 706, name = "Somali Shilling"),
			make(code = "SRD", defaultFractionDigits = 2, numericCode = 968, name = "Surinam Dollar"),
			make(code = "SSP", defaultFractionDigits = 2, numericCode = 728, name = "South Sudanese Pound"),
			make(code = "STN", defaultFractionDigits = 2, numericCode = 930, name = "Dobra"),
			make(code = "SVC", defaultFractionDigits = 2, numericCode = 222, name = "El Salvador Colon"),
			make(code = "SYP", defaultFractionDigits = 2, numericCode = 760, name = "Syrian Pound"),
			make(code = "SZL", defaultFractionDigits = 2, numericCode = 748, name = "Lilangeni"),
			make(code = "THB", defaultFractionDigits = 2, numericCode = 764, name = "Baht"),
			make(code = "TJS", defaultFractionDigits = 2, numericCode = 972, name = "Somoni"),
			make(code = "TMT", defaultFractionDigits = 2, numericCode = 934, name = "Turkmenistan New Manat"),
			make(code = "TND", defaultFractionDigits = 3, numericCode = 788, name = "Tunisian Dinar"),
			make(code = "TOP", defaultFractionDigits = 2, numericCode = 776, name = "Pa’anga"),
			make(code = "TRY", defaultFractionDigits = 2, numericCode = 949, name = "Turkish Lira"),
			make(code = "TTD", defaultFractionDigits = 2, numericCode = 780, name = "Trinidad and Tobago Dollar"),
			make(code = "TWD", defaultFractionDigits = 2, numericCode = 901, name = "New Taiwan Dollar"),
			make(code = "TZS", defaultFractionDigits = 2, numericCode = 834, name = "Tanzanian Shilling"),
			make(code = "UAH", defaultFractionDigits = 2, numericCode = 980, name = "Hryvnia"),
			make(code = "UGX", defaultFractionDigits = 0, numericCode = 800, name = "Uganda Shilling"),
			make(code = "USD", defaultFractionDigits = 2, numericCode = 840, name = "US Dollar"),
			make(code = "USN", defaultFractionDigits = 2, numericCode = 997, name = "US Dollar (Next day)"),
			make(code = "UYI", defaultFractionDigits = 0, numericCode = 940, name = "Uruguay Peso en Unidades Indexadas (UI)"),
			make(code = "UYU", defaultFractionDigits = 2, numericCode = 858, name = "Peso Uruguayo"),
			make(code = "UYW", defaultFractionDigits = 4, numericCode = 927, name = "Unidad Previsional"),
			make(code = "UZS", defaultFractionDigits = 2, numericCode = 860, name = "Uzbekistan Sum"),
			make(code = "VES", defaultFractionDigits = 2, numericCode = 928, name = "Bolívar Soberano"),
			make(code = "VND", defaultFractionDigits = 0, numericCode = 704, name = "Dong"),
			make(code = "VUV", defaultFractionDigits = 0, numericCode = 548, name = "Vatu"),
			make(code = "WST", defaultFractionDigits = 2, numericCode = 882, name = "Tala"),
			make(code = "XAF", defaultFractionDigits = 0, numericCode = 950, name = "CFA Franc BEAC"),
			make(code = "XAG", defaultFractionDigits = -1, numericCode = 961, name = "Silver"),
			make(code = "XAU", defaultFractionDigits = -1, numericCode = 959, name = "Gold"),
			make(code = "XBA", defaultFractionDigits = -1, numericCode = 955, name = "Bond Markets Unit European Composite Unit (EURCO)"),
			make(code = "XBB", defaultFractionDigits = -1, numericCode = 956, name = "Bond Markets Unit European Monetary Unit (E.M.U.-6)"),
			make(code = "XBC", defaultFractionDigits = -1, numericCode = 957, name = "Bond Markets Unit European Unit of Account 9 (E.U.A.-9)"),
			make(code = "XBD", defaultFractionDigits = -1, numericCode = 958, name = "Bond Markets Unit European Unit of Account 17 (E.U.A.-17)"),
			make(code = "XCD", defaultFractionDigits = 2, numericCode = 951, name = "East Caribbean Dollar"),
			make(code = "XDR", defaultFractionDigits = -1, numericCode = 960, name = "SDR (Special Drawing Right)"),
			make(code = "XOF", defaultFractionDigits = 0, numericCode = 952, name = "CFA Franc BCEAO"),
			make(code = "XPD", defaultFractionDigits = -1, numericCode = 964, name = "Palladium"),
			make(code = "XPF", defaultFractionDigits = 0, numericCode = 953, name = "CFP Franc"),
			make(code = "XPT", defaultFractionDigits = -1, numericCode = 962, name = "Platinum"),
			make(code = "XSU", defaultFractionDigits = -1, numericCode = 994, name = "Sucre"),
			make(code = "XTS", defaultFractionDigits = -1, numericCode = 963, name = "Testing Currency Code"),
			make(code = "XUA", defaultFractionDigits = -1, numericCode = 965, name = "ADB Unit of Account"),
			make(code = "XXX", defaultFractionDigits = -1, numericCode = 999, name = "Unknown Currency"),
			make(code = "YER", defaultFractionDigits = 2, numericCode = 886, name = "Yemeni Rial"),
			make(code = "ZAR", defaultFractionDigits = 2, numericCode = 710, name = "Rand"),
			make(code = "ZMW", defaultFractionDigits = 2, numericCode = 967, name = "Zambian Kwacha"),
			make(code = "ZWL", defaultFractionDigits = 2, numericCode = 932, name = "Zimbabwe Dollar"),
		)


		private val allByCode: Map<CurrencyCode, Currency> = all.associateByTo(hashMapOf()) { it.code }


		private fun make(code: String, defaultFractionDigits: Int, numericCode: Int, name: String): Currency =
			Currency(
				code = CurrencyCode(code),
				defaultFractionDigits = defaultFractionDigits,
				name = name,
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
