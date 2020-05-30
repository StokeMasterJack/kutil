package ss.kutil



fun <T : Comparable<T>> Pair<T, T>.toList(): List<T> = listOf(first, second)


fun <T : Comparable<T>> Pair<T, T>.sort(): Pair<T, T> = toList().sorted().toPair()
