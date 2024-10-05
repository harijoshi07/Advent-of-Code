package aoc2023

import java.io.File

fun main() {
    val lines = File("src/aoc2023/input1_1.txt").readLines()
    val sum = lines.sumOf { line -> extractValue(line) }
    println("Sum: $sum")
}

fun extractValue(line: String): Int {
    val digits = findDigits(line)
    return digits.first() * 10 + digits.last()
}

fun findDigits(line: String): List<Int> {
    val numberWords = mapOf(
        "one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5,
        "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9
    )

    val digits = mutableListOf<Int>()

    for (i in line.indices) {
        if (line[i].isDigit()) {
            digits.add(line[i].digitToInt())
        } else {
            for ((word, value) in numberWords) {
                if (line.substring(i).startsWith(word)) {
                    digits.add(value)
                }
            }
        }
    }

    return digits
}