package io.fluidsonic.currency


/** Returns `true` if this character is an ASCII Latin letter (A-Z or a-z). */
internal fun Char.isLatinLetter() =
	this in 'a' .. 'z' || this in 'A' .. 'Z'
