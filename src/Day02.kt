fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf {
            val (a, b) = it.split(" ")

            val score: Int = when (a) {
                "A" -> when (b) {
                    "X" -> 1 + 3
                    "Y" -> 2 + 6
                    else -> 3 + 0
                }

                "B" -> when (b) {
                    "X" -> 1 + 0
                    "Y" -> 2 + 3
                    else -> 3 + 6
                }

                else -> when (b) {
                    "X" -> 1 + 6
                    "Y" -> 2 + 0
                    else -> 3 + 3
                }
            }

            return@sumOf score
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf {
            val (a, b) = it.split(" ")

            val score: Int = when (a) {
                "A" -> when (b) {
                    "X" -> 3 + 0
                    "Y" -> 1 + 3
                    else -> 2 + 6
                }

                "B" -> when (b) {
                    "X" -> 1 + 0
                    "Y" -> 2 + 3
                    else -> 3 + 6
                }

                else -> when (b) {
                    "X" -> 2 + 0
                    "Y" -> 3 + 3
                    else -> 1 + 6
                }
            }

            return@sumOf score
        }
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
