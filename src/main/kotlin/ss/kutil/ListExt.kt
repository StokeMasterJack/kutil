package ss.kutil

fun <T : Comparable<T>> List<T>.toPair(): Pair<T, T> = Pair(this[0], this[1])