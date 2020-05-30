package ss.kutil

import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

private fun d(y: Int, m: Int, d: Int): LocalDate = LocalDate.of(y, m, d)


@ExperimentalUnsignedTypes
class LocalDateExtTest {

    @Test
    fun testDayDiff() {

        assDiff(0, d(2016, 1, 1), d(2016, 1, 1))
        assDiff(1, d(2016, 1, 1), d(2016, 1, 2))
        assDiff(9, d(2016, 1, 1), d(2016, 1, 10))

        assDiff(366, d(2016, 1, 1), d(2017, 1, 1))  //leapYear
        assDiff(365, d(2017, 1, 1), d(2018, 1, 1))

        assDiff(29, d(2016, 2, 1), d(2016, 3, 1))  //leapMonth
        assDiff(28, d(2017, 2, 1), d(2017, 3, 1))  //leapYear
    }

    @Test
    fun testNextPrev() {
        val d0 = d(2015, 12, 31)
        val d1 = d(2016, 1, 1)
        val d2 = d(2016, 1, 2)
        val d3 = d(2016, 1, 3)
        assertEquals(d0, d1.previous())
        assertEquals(d2, d1.next())

        assertEquals(d1, d2.previous())
        assertEquals(d3, d2.next())
    }
}

@ExperimentalUnsignedTypes
fun assDiff(exp: Int, d1: LocalDate, d2: LocalDate) {
    val diff1 = d1.diff(d2)
    val diff2 = d2.diff(d1)
    assertEquals(exp, diff1)
    assertEquals(exp, diff2)
}