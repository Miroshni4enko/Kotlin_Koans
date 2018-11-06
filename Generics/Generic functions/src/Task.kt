import java.util.*

fun <T, C : MutableCollection<in T>, D : MutableCollection<in T>> Iterable<T>.partitionTo(destination1: C
                                                                                          , destination2: D
                                                                                          , divider: T.(arg:T) -> Boolean): Pair<C,D>{
    forEach{
       if (it.divider(it)) destination1.add(it) else destination2.add(it)
    }

    return Pair(destination1, destination2)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e").
            partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
    words == listOf("a", "c")
    lines == listOf("a b", "d e")
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}').
            partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
    letters == setOf('a', 'r')
    other == setOf('%', '}')
}
