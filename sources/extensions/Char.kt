package io.fluidsonic.currency


internal fun Char.isLatinLetter() =
	this in 'a' .. 'z' || this in 'A' .. 'Z'
