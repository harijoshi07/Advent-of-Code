package aoc2023

import java.io.File

fun main() {
    val lines = File("src/aoc2023/input1_1.txt").readLines()
    val convertedLines = convertNumberInWordsToDigitsForList(lines)
    val sum = calculateSumOfDigits(convertedLines)
    println("Sum: $sum")
}

fun convertNumberInWordsToDigits(input: String): String {
    val numberWordToDigitMap = mapOf(
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9",
        "zero" to "0"
    )

    var updatedInput = input
    for ((word, digit) in numberWordToDigitMap) {
        updatedInput = updatedInput.replace(word, digit)
    }
    return updatedInput
}

fun convertNumberInWordsToDigitsForList(lines: List<String>): List<String> {
    return lines.map { line -> convertNumberInWordsToDigits(line) }
}

fun calculateSumOfDigits(lines: List<String>): Int {
    var sum = 0

    for (line in lines) {
        val collectDigits = line.filter { it.isDigit() }
        if (collectDigits.isNotEmpty()) {
            val firstDigit = collectDigits.first()
            val lastDigit = collectDigits.last()
            val twoDigits = "$firstDigit$lastDigit".toInt()
            sum += twoDigits
        }
    }

    return sum
}