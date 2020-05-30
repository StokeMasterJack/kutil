package ss.kutil

sealed class Case {
    object Upper : Case()
    object Lower : Case()
    object SameAsInput : Case()
}

fun String.lastNChars(n: Int): String {
    require(n >= 0)
    if (n == 0) return ""
    if (n > this.length) return this
    val i1 = length - n
    val i2 = length
    return this.substring(i1, i2)
}


fun String.firstNChars(n: Int): String {
    require(n >= 0)
    if (n == 0) return ""
    if (n > this.length) return this
    return this.substring(0, n)
}


val String.upperCaseFirstLetter: String get() = firstLetter(Case.Upper)
val String.lowerCaseFirstLetter: String get() = firstLetter(Case.Lower)

fun String.transformFirstLetter(action: Case): String {
    if (this.isEmpty() || action == Case.SameAsInput) return this
    val c = this.firstNChars(1).case(action)
    return this.replaceRange(0, 1, c)
}

fun String.firstLetter(action: Case) = transformFirstLetter(action)

fun Char.case(case: Case): Char = when (case) {
    Case.Lower -> toLowerCase()
    Case.Upper -> toUpperCase()
    Case.SameAsInput -> this
}

fun String.case(case: Case): String = when (case) {
    Case.Lower -> toLowerCase()
    Case.Upper -> toUpperCase()
    Case.SameAsInput -> this
}

fun String.camelize(firstLetter: Case = Case.Lower): String = camel(firstLetter)

fun String.camel(firstLetter: Case = Case.Lower): String {
    return mapIndexed { i, c ->
        when {
            i == 0 -> c.case(firstLetter)
            this[i - 1] == ' ' -> c.toUpperCase()
            else -> c
        }
    }.filterNot { it.isWhitespace() }.joinToString(separator = "")
}

fun String.uncamel(firstLetter: Case = Case.Upper): String {
    val sb = StringBuilder()
    for (c in this) {
        if (c.isUCase) {
            sb.append(" ")
        }
        sb.append(c)
    }
    val s = sb.toString().trim()
    return s.firstLetter(firstLetter)
}

fun String?.trimTrailing(thingToChomp: String): String? = Strings.chompTrailing(this, thingToChomp)
fun String?.trimLeading(thingToChomp: String): String? = Strings.chompLeading(this, thingToChomp)

fun String?.iEmpty(): Boolean {
    return this == null || isEmpty() || isNullStr()
}

fun String?.isMissing(): Boolean {
    return this == null || isEmpty() || isNullStr()
}

fun String.isNullStr(): Boolean = this.trim().equals("null", ignoreCase = true)

fun String?.isNotMissing(): Boolean {
    return !isMissing()
}

fun String?.nullToEmptyString(): String = this?.trim() ?: ""
fun String?.nullNormalize(): String? = Strings.nullNormalize(this)

fun String.lpad(desiredFinalLength: Int, padChar: Char = ' '): String = Strings.lpad(this, desiredFinalLength , padChar )


fun String.rpad(desiredFinalLength: Int, padChar: Char = ' '): String =
    Strings.rpad(this, desiredFinalLength , padChar )


fun String?.isInt(): Boolean {
    if (this == null) return false
    return try {
        this.toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }
}

fun String?.isNotInt(): Boolean = !isInt()