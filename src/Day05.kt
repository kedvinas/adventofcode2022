fun main() {
    fun part1(input: List<String>): String {
        val stacks = mutableListOf<MutableList<String>>()

        var i = 0

        val line = input[i].chunked(4)

        line.forEach {
            stacks.add(mutableListOf(it))
        }

        while (true) {
            if (input[++i].isEmpty()) {
                break
            }

            val split = input[i].chunked(4)

            split.forEachIndexed { j, it ->
                stacks[j].add(it)
            }
        }

        stacks.forEach { stack -> stack.removeAll { !it.contains("[") } }
        stacks.forEach { it.reverse() }

        while (++i < input.size) {
            val split = input[i].split(" ")

            var count = split[1].toInt()
            val from = split[3].toInt() - 1
            val to = split[5].toInt() - 1

            while (count-- > 0) {
                stacks[to].add(stacks[from].removeLast())
            }
        }

        return stacks.map { it.last().replace("[\\[\\] ]".toRegex(), "") }.joinToString(separator = "")
    }

    fun part2(input: List<String>): String {
        val stacks = mutableListOf<MutableList<String>>()

        var i = 0

        val line = input[i].chunked(4)

        line.forEach {
            stacks.add(mutableListOf(it))
        }

        while (true) {
            if (input[++i].isEmpty()) {
                break
            }

            val split = input[i].chunked(4)

            split.forEachIndexed { j, it ->
                stacks[j].add(it)
            }
        }

        stacks.forEach { stack -> stack.removeAll { !it.contains("[") } }
        stacks.forEach { it.reverse() }

        while (++i < input.size) {
            val split = input[i].split(" ")

            var count = split[1].toInt()
            val from = split[3].toInt() - 1
            val to = split[5].toInt() - 1

            val toMove = stacks[from].takeLast(count)
            stacks[from] = stacks[from].dropLast(count).toMutableList()
            stacks[to].addAll(toMove)
        }

        return stacks.map { it.last().replace("[\\[\\] ]".toRegex(), "") }.joinToString(separator = "")
    }

    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
