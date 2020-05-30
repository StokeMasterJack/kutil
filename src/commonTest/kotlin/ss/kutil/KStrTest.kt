package ss.kutil

import kotlin.test.Test
import kotlin.test.assertEquals

class KStrTest {

    @Test
    fun stringCase() {
        with("D") {
            assertEquals("D", case(Case.Upper))
            assertEquals("d", case(Case.Lower))
            assertEquals("D", case(Case.SameAsInput))
        }
        with("d") {
            assertEquals("D", case(Case.Upper))
            assertEquals("d", case(Case.Lower))
            assertEquals("d", case(Case.SameAsInput))
        }
        with("DaveFord") {
            assertEquals("DAVEFORD", case(Case.Upper))
            assertEquals("daveford", case(Case.Lower))
            assertEquals("DaveFord", case(Case.SameAsInput))
        }
    }

    @Test
    fun charCase() {
        with('D') {
            assertEquals('D', case(Case.Upper))
            assertEquals('d', case(Case.Lower))
            assertEquals('D', case(Case.SameAsInput))
        }
        with('d') {
            assertEquals('D', case(Case.Upper))
            assertEquals('d', case(Case.Lower))
            assertEquals('d', case(Case.SameAsInput))
        }
    }

    @Test
    fun firstNChars() {
        with("abc") {
            assertEquals("", firstNChars(0))
            assertEquals("a", firstNChars(1))
            assertEquals("ab", firstNChars(2))
            assertEquals("abc", firstNChars(3))
            assertEquals("abc", firstNChars(4))
            assThrows(IllegalArgumentException::class) { firstNChars(-3) }
        }
    }

    @Test
    fun lastNChars() {
        with("abc") {
            assertEquals("", lastNChars(0))
            assertEquals("c", lastNChars(1))
            assertEquals("bc", lastNChars(2))
            assertEquals("abc", lastNChars(3))
            assertEquals("abc", lastNChars(4))
            assThrows(IllegalArgumentException::class) { lastNChars(-3) }
        }
    }

    @Test
    fun transformFirstLetter() {
        with("abc") {
            assertEquals("Abc", transformFirstLetter(Case.Upper))
            assertEquals("abc", transformFirstLetter(Case.Lower))
            assThrows(IllegalArgumentException::class) { lastNChars(-3) }
        }
    }

    @Test
    fun camel() {

        with("Dave Ford") {
            assertEquals("daveFord", camel())
            assertEquals("daveFord", camel(firstLetter = Case.Lower))
            assertEquals("DaveFord", camel(firstLetter = Case.Upper))
            assertEquals("DaveFord", camel(firstLetter = Case.SameAsInput))
        }

        with("dave Ford") {
            assertEquals("daveFord", camel())
            assertEquals("daveFord", camel(firstLetter = Case.Lower))
            assertEquals("DaveFord", camel(firstLetter = Case.Upper))
            assertEquals("daveFord", camel(firstLetter = Case.SameAsInput))
        }

        with("dave ford") {
            assertEquals("daveFord", camel())
            assertEquals("daveFord", camel(firstLetter = Case.Lower))
            assertEquals("DaveFord", camel(firstLetter = Case.Upper))
            assertEquals("daveFord", camel(firstLetter = Case.SameAsInput))
        }
    }

    @Test
    fun uncamel() {
        with("DaveFord") {
            assertEquals("Dave Ford", uncamel())
            assertEquals("Dave Ford", uncamel(Case.Upper))
            assertEquals("dave Ford", uncamel(Case.Lower))
            assertEquals("Dave Ford", uncamel(Case.SameAsInput))
        }
    }

    @Test
    fun chomp() {
        assertEquals("abc", "abc,".trimTrailing(","))
        assertEquals("abc", "abc,q".trimTrailing(",q"))
        assertEquals("abc", ",abc".trimLeading(","))
        assertEquals("abc", ",qabc".trimLeading(",q"))

    }
}




