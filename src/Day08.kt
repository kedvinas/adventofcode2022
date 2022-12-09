import kotlin.math.max

fun main() {
    fun part1(input: List<String>): Int {
        val grid = input.map {
            it.toCharArray().map { it.digitToInt() }
        }

        val visible = Array(grid.size) {
            Array(grid.size) {
                0
            }
        }

        for (i in 0 until grid.size) {
            var max = -1
            for (j in 0 until grid.size) {
                if (grid[i][j] > max) {
                    visible[i][j]++
                    max = grid[i][j]
                }
            }
        }

        for (i in 0 until grid.size) {
            var max = -1
            for (j in grid.size - 1 downTo 0) {
                if (grid[i][j] > max) {
                    visible[i][j]++
                    max = grid[i][j]
                }
            }
        }

        for (i in 0 until grid.size) {
            var max = -1
            for (j in 0 until grid.size) {
                if (grid[j][i] > max) {
                    visible[j][i]++
                    max = grid[j][i]
                }
            }
        }

        for (i in grid.indices) {
            var max = -1
            for (j in grid.size - 1 downTo 0) {
                if (grid[j][i] > max) {
                    visible[j][i]++
                    max = grid[j][i]
                }
            }
        }

        var sum = 0

        for (x in 0 until visible.size) {
            for (y in 0 until visible.size) {
                if (visible[x][y] > 0) {
                    sum++
                }
            }
        }

        return sum
    }

    fun part2(input: List<String>): Int {
        val grid = input.map {
            it.toCharArray().map { it.digitToInt() }
        }

        var max = 0

        for (i in 1 until grid.size - 1) {
            for (j in 1 until grid.size - 1) {
                var left = 0
                var right = 0
                var top = 0
                var bottom = 0

                for (k in i + 1 until grid.size) {
                    bottom++

                    if (grid[i][j] <= grid[k][j]) {
                        break
                    }
                }

                for (k in i - 1 downTo 0) {
                    top++
                    if (grid[i][j] <= grid[k][j]) {
                        break
                    }
                }

                for (k in j + 1 until grid.size) {
                    right++
                    if (grid[i][j] <= grid[i][k]) {
                        break
                    }
                }

                for (k in j - 1 downTo 0) {
                    left++
                    if (grid[i][j] <= grid[i][k]) {
                        break
                    }
                }

                max = max(max, left * right * top * bottom)
            }
        }

        return max
    }

    val testInput = readInput("Day08_test")
    check(part1(testInput) == 21)
    check(part2(testInput) == 8)

    val input = readInput("Day08")
    println(part1(input))
    println(part2(input))
}
