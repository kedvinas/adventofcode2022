fun main() {
    fun part1(input: List<String>): Int {
        val buffer = input[0]

        for (i in buffer.indices) {
            val differentChars = buffer.substring(i, i + 4)
                .toCharArray()
                .toSet()
                .size

            if (differentChars == 4) {
                return i + 4
            }
        }

        return input.size
    }

    fun part2(input: List<String>): Int {
        val buffer = input[0]
        val charMap = mutableMapOf<Char, Int>()

        buffer.take(14)
            .forEach {
                charMap[it] = charMap.getOrDefault(it, 0) + 1
            }

        for (i in buffer.indices) {
            if (charMap.size == 14) {
                return i + 14
            }

            val oldChar = buffer[i]
            val newChar = buffer[i + 14]

            val charCount = charMap[oldChar]

            if (charCount == 1) {
                charMap.remove(oldChar)
            } else {
                charMap[oldChar] = charMap.getValue(oldChar) - 1
            }

            charMap[newChar] = charMap.getOrDefault(newChar, 0) + 1
        }

        return input.size
    }

    val testInput = readInput("Day06_test")
    check(part1(testInput) == 11)
    println(part2(testInput))
    check(part2(testInput) == 26)

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}
