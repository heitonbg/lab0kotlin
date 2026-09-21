fun main(args: Array<String>) {
    val words: List<String> = if (args.isNotEmpty()) {
        args.toList()
    } else {
        generateSequence(::readLine)
            .flatMap { it.split(Regex("\\s+")).asSequence() }
            .filter { it.isNotBlank() }
            .toList()
    }

    words.groupingBy { it }
        .eachCount()
        .entries
        .sortedWith(compareByDescending<Map.Entry<String, Int>> { it.value }.thenBy { it.key })
        .forEach { (word, count) -> println("$word $count") }
}