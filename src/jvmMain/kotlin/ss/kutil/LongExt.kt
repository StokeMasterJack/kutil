package ss.kutil

import java.text.DecimalFormat

fun Long.fmtTime(): String {
    val d = java.util.Date(this)
    @Suppress("DEPRECATION")
    return d.toGMTString()
}

fun Long?.fmt(pattern: String): String {
    if (this == null) return "";
    val format = DecimalFormat(pattern)
    return format.format(this)
}

fun Long?.fmt(): String {
    if (this == null) return "";
    return this.fmt("###,###,###")
}

fun Long.lpad(desiredFinalLength: Int, padChar: Char = ' '): String =
    Strings.lpad(this.toString(), desiredFinalLength, padChar)