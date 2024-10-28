package aoc2015

import java.io.File

fun main() {
    val input = File("src/aoc2015/input01.txt").readText()
    basementIndexPosition(input)
}

fun basementIndexPosition(input: String) {

    var sum = 0

    input.forEachIndexed { index, char ->
        if (char == '(') sum += 1 else sum -= 1

        if (sum == -1){
            println("Position of Char at which we reach basement =${index + 1}")
            return
        }
    }
}