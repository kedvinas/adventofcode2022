fun main() {
    fun part1(input: List<String>): Int {
        val files = mutableListOf<File>()

        var workingDirectory = ""

        for (i in input) {
            val split = i.split(" ")

            if (split[0] == "$") {
                if (split[1] == "cd") {
                    if (split[2] == "/") {
                        workingDirectory = "/"
                    } else if (split[2] == "..") {
                        workingDirectory = workingDirectory.dropLast(1).replaceAfterLast("/", "")
                    } else {
                        workingDirectory += "${split[2]}/"
                    }
                }
            } else {
                if (split[0] != "dir") {
                    files.add(File(name = "$workingDirectory${split[1]}", size = split[0].toInt()))
                }
            }
        }

        val directorySizes = mutableMapOf<String, Int>()

        for (f in files) {
            var name = f.name.replaceAfterLast("/", "")

            while (name.isNotEmpty()) {
                var size = directorySizes.getOrDefault(name, 0)

                directorySizes[name] = size + f.size

                name = name.dropLast(1).replaceAfterLast("/", "")
            }
        }

        var sum = 0

        for (d in directorySizes) {
            if(d.value <= 100000) {
                sum += d.value
            }
        }

        return sum
    }

    fun part2(input: List<String>): Int {
        val files = mutableListOf<File>()

        var workingDirectory = ""

        for (i in input) {
            val split = i.split(" ")

            if (split[0] == "$") {
                if (split[1] == "cd") {
                    if (split[2] == "/") {
                        workingDirectory = "/"
                    } else if (split[2] == "..") {
                        workingDirectory = workingDirectory.dropLast(1).replaceAfterLast("/", "")
                    } else {
                        workingDirectory += "${split[2]}/"
                    }
                }
            } else {
                if (split[0] != "dir") {
                    files.add(File(name = "$workingDirectory${split[1]}", size = split[0].toInt()))
                }
            }
        }

        val directorySizes = mutableMapOf<String, Int>()

        for (f in files) {
            var name = f.name.replaceAfterLast("/", "")

            while (name.isNotEmpty()) {
                var size = directorySizes.getOrDefault(name, 0)

                directorySizes[name] = size + f.size

                name = name.dropLast(1).replaceAfterLast("/", "")
            }
        }

        val requiredSpace = 30000000 - (70000000 - directorySizes["/"]!!)

        return directorySizes.map { it.value }.sorted().takeLastWhile { it > requiredSpace }.first()
    }

    val testInput = readInput("Day07_test")
    check(part1(testInput) == 95437)
    check(part2(testInput) == 24933642)

    val input = readInput("Day07")
    println(part1(input))
    println(part2(input))
}

class File(
    val name: String,
    val size: Int
)
