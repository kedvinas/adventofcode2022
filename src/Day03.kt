fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0

        for (i in input) {
            val firstHalf = i.substring(0, i.length / 2).toCharArray().toSet()
            val secondHalf = i.substring(i.length / 2).toCharArray().toSet()

            val intersection = firstHalf.intersect(secondHalf).elementAt(0)

            sum += if (intersection.isLowerCase()) {
                intersection.code - 96
            } else {
                intersection.code - 38
            }
        }

        return sum
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3).sumOf { group ->
            val charArrays = group.map {
                it.toCharArray().toSet()
            }

            val intersection = charArrays.fold(charArrays[0]) { acc, chars -> acc.intersect(chars) }
                .elementAt(0)

            if (intersection.isLowerCase()) {
                intersection.code - 96
            } else {
                intersection.code - 38
            }
        }
    }

    val testInput = readInput("Day03_test")
    println(part2(testInput))
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
