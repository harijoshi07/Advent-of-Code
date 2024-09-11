package aoc2023
import java.io.File

//Easy Method
fun main() {
    // Read all lines from the file
    val lines = File("src/input.txt").readLines()

    var sum = 0

    // Process each line
    lines.forEach { line ->
        val collectDigits = mutableListOf<Char>()

        // Collect all digits from the line
        line.forEach { char ->
            if (char.isDigit()) {
                collectDigits.add(char)
            }
        }
        val firstDigit = collectDigits.first()
        val lastDigit = collectDigits.last()

        // Combine first and last digit to form a two-digit number
        val twoDigits = "$firstDigit $lastDigit".toInt()

        sum += twoDigits
    }
    println("Sum: $sum")
}


//Best Method
/*
fun main() {
    val input = File("src/input.txt").readLines()
    val calibrationSum = input.sumOf { line ->
        val digits = line.filter { it.isDigit() }
        "${digits.first()} ${digits.last()}".toInt()
    }
    println("The sum of all calibration values is: $calibrationSum")
}
 */