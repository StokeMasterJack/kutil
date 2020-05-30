package ss.kutil

import java.text.DecimalFormat
import java.text.NumberFormat
import kotlin.Double


    fun Double?.fmt(): String {
        if (this == null) return "";
        return this.fmt("###,##0.00")
    }

    fun Double?.fmt(pattern: String): String {
        if (this == null) return "";
        val format = DecimalFormat(pattern)
        return format.format(this)
    }

    fun Double?.cur(): String {
        if (this == null) return "";
        val currencyInstance = NumberFormat.getCurrencyInstance()
        return currencyInstance.format(this)
    }

    fun Double?.pct(): String {
        if (this == null) return "";
        return (this * 100).fmt() + "%"
    }