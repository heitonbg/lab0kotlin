fun main(args: Array<String>) {
    args.groupingBy { it }
        .eachCount()
        .entries
        .sortedWith(compareByDescending<Map.Entry<String, Int>> { it.value }.thenBy { it.key })
        .forEach { (word, count) -> println("$word $count") }
}