import kotlin.math.max

fun main() {
    fun part1(input: List<String>): Int {
        var max = 0
        var current = 0

        for (i in input) {
            if (i.isNotEmpty()) {
                current += i.toInt()
            } else {
                max = max(current, max)
                current = 0
            }
        }

        return max(current, max)
    }

    fun part2(input: List<String>): Int {
        var total = mutableListOf<Int>()
        var current = 0

        for (i in input) {
            if (i.isNotEmpty()) {
                current += i.toInt()
            } else {
                total.add(current)
                current = 0
            }
        }

        total.add(current)

        return total.sorted().takeLast(3).sum()
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
