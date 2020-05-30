package ss.kutil

import java.time.LocalDate
import java.time.Period
import kotlin.streams.asSequence

typealias LocalDatePair = Pair<LocalDate, LocalDate>

fun LocalDatePair.diffDead(): Int {
    val (a, b) = this.sort()
    return (if (a == b) {
        0
    } else {
        val p = Period.ofDays(1)
        val seq = a.datesUntil(b, p).asSequence()
        seq.count()
    }).apply { this >= 0 }
}


fun LocalDatePair.diff(): Int {
    val (a, b) = this.sort()

    var count = 0
    var cur: LocalDate = a

    while (true) {
        if (cur == b) {
            break
        }
        cur = cur.next()
        count++
    }

    check(count >= 0)

    return count


}