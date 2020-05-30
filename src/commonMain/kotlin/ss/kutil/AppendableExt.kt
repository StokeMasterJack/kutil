package ss.kutil


fun <T : Appendable> T.indent(tabCount: Int = 0, tabSize: Int = 2): T {
    repeat(tabCount) {
        repeat(tabSize) {
            append(' ')
        }
    }
    return this
}

fun <T : Appendable> T.appendRepeat(thingToAppend: Any, repeatCount: Int): T {
    repeat(repeatCount) { append(thingToAppend.toString()) }
    return this
}

fun <T : Appendable> T.pad(padCount: Int, padChar: Char = ' '): T {
    repeat(padCount) { append(padChar) }
    return this
}

fun <T : Appendable> T.prindent(
    tabCount: Int = 0,
    tabSize: Int = 2,
    thingToPrint: Any
): T {
    indent(tabCount = tabCount, tabSize = tabSize)
    append(thingToPrint.toString())
    return this
}
