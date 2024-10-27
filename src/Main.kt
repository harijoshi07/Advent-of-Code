fun main() {
    val input = "twonegcrssevensix37twooneightgt"
    val sum = extractCalibrationValuee(input)
    println("Sum: $sum")
}

fun extractCalibrationValuee(line: String): Int {
    val digits = findDigitss(line)
    // println(digits.first() * 10 + digits.last())
    return digits.first() * 10 + digits.last()
}

fun findDigitss(line: String): List<Int> {
    val numberWords = mapOf(
        "one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5,
        "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9
    )

    val digits = mutableListOf<Int>()
    var index = 0

    while (index < line.length) {
        if (line[index].isDigit()) {
            digits.add(line[index].digitToInt())
            index++
        } else {
            var found = false
            for ((word, value) in numberWords) {
                if (line.substring(index).startsWith(word)) {
                    digits.add(value)
                    index += word.length
                    found = true
                    break
                }
            }
            if (!found) {
                index++
            }
        }
    }

    return digits
}
