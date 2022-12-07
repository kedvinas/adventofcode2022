import kotlin.math.max
import kotlin.math.min

fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0

        for (i in input) {
            val (a, b) = i.split(",")

            val (ax, ay) = a.split("-").map { it.toInt() }
            val (bx, by) = b.split("-").map { it.toInt() }

            if (ax <= bx && ay >= by || bx <= ax && by >= ay) {
                sum++
            }
        }

        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0

        for (i in input) {
            val (a, b) = i.split(",")

            val (ax, ay) = a.split("-").map { it.toInt() }
            val (bx, by) = b.split("-").map { it.toInt() }

            if (max(ax, bx) <= min(ay, by)) {
                sum++
            }
        }

        return sum
    }

    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
