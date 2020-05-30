@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package ss.kutil

import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlin.reflect.KClass

object Strings {

    const val CrLf = "\r\n"

    fun mk(thingToAppend: Any, repeatCount: Int): String =
        StringBuilder().appendRepeat(thingToAppend, repeatCount).toString()

    fun lpad(unpaddedString: String, desiredFinalLength: Int, padChar: Char): String {
        val padCount = desiredFinalLength - unpaddedString.length
        val sb = StringBuilder()
        for (i in 0 until padCount) {
            sb.append(padChar)
        }
        sb.append(unpaddedString)
        return sb.toString()
    }

    fun lpad(unpaddedString: Int, desiredFinalLength: Int): String = lpad(unpaddedString.toString(), desiredFinalLength)

    fun lpad(unpaddedString: String, padChar: Char, desiredFinalLength: Int): String =
        lpad(unpaddedString, desiredFinalLength, padChar)

    fun lpad(unpaddedString: String, desiredFinalLength: Int) = lpad(unpaddedString, ' ', desiredFinalLength)


    fun rpad(unpaddedString: String, desiredFinalLength: Int) = rpad(unpaddedString, ' ', desiredFinalLength)

    fun rpad(unpaddedString: String, desiredFinalLength: Int, padChar: Char) =
        rpad(unpaddedString, padChar, desiredFinalLength)

    fun rpad(unpaddedString: String, padChar: Char, desiredFinalLength: Int): String {
        val padCount = desiredFinalLength - unpaddedString.length
        val sb = StringBuilder()
        sb.append(unpaddedString)
        for (i in 0 until padCount) {
            sb.append(padChar)
        }
        return sb.toString()
    }

    fun pad(padCount: Int, padChar: Char = ' '): String =
        StringBuilder().pad(padCount = padCount, padChar = padChar).toString()

    @JvmStatic
    fun chompTrailing(input: String?, thingToChomp: String): String? {
        if (input == null || input.trim { it <= ' ' } == "") return input
        return if (input.endsWith(thingToChomp)) {
            input.substring(0, input.length - thingToChomp.length)
        } else {
            input
        }
    }

    @JvmStatic
    fun chompTrailingComma(input: String?): String? = chompTrailing(input, ",")

    @JvmStatic
    fun chompLeading(input: String?, thingToChomp: String): String? {
        if (input == null || input.trim { it <= ' ' } == "") return input
        return if (input.startsWith(thingToChomp)) {
            input.substring(thingToChomp.length)
        } else {
            input
        }
    }

    fun getSubName(subclass: String, superclass: String): String {
        val n1: String = subclass
        val n2: String = superclass
        val i = n1.indexOf(n2)
        return n1.substring(0, i)
    }

    fun <T1 : T2, T2 : Any> getSubName(subclass: KClass<T1>, superclass: KClass<T2>): String {
        val n1: String = subclass.simpleName!!
        val n2: String = superclass.simpleName!!
        return getSubName(n1, n2)
    }

    @JvmStatic @JvmOverloads
    fun indent(tabCount: Int, tabSize: Int = 2): String =
        StringBuilder().indent(tabCount = tabCount, tabSize = tabSize).toString()

    fun nullNormalize(s: String?): String? = if (s.isNullOrBlank()) null else s.trim()

    fun isInt(s: String?): Boolean {
        if (s == null) return false
        return try {
            s.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    fun isEmpty(s: Any?): Boolean {
        return s == null || s.toString().isEmpty()
    }

    @JvmStatic
    fun isBlank(s: String?): Boolean = s.isNullOrBlank()

    @JvmStatic
    fun isEmpty(s: String?): Boolean = s.isNullOrEmpty()

    @JvmStatic
    fun isNotEmpty(s: String?): Boolean = !isEmpty(s)

    @JvmStatic
    fun notEmpty(s: String?): Boolean = !isEmpty(s)
}
