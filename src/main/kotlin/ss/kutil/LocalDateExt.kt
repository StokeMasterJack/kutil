package ss.kutil

import java.time.LocalDate

infix fun LocalDate.toPair(other: LocalDate): LocalDatePair = to<LocalDate, LocalDate>(other)

fun LocalDate.diff(other: LocalDate): Int {
    val localDatePair: LocalDatePair = toPair(other)
    return localDatePair.diff()
}

fun LocalDate.minusDays(daysToSubtract: Int) = minusDays(daysToSubtract.toLong())
fun LocalDate.plusDays(daysToAdd: Int) = plusDays(daysToAdd.toLong())

fun LocalDate.next(): LocalDate = plusDays(1L)
fun LocalDate.previous(): LocalDate = minusDays(1L)