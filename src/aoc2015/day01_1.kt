package aoc2015

import java.io.File

fun main() {
    val input = File("src/aoc2015/input01.txt").readText()
    println(input)
    val output = calcNoOfFloors(input)
    println(output)

}

fun calcNoOfFloors(input: String): Int {
    var countUp = 0
    var countDown = 0

    input.forEach { it ->
        if (it == '(') {
            countUp += 1
        } else {
            countDown += 1
        }
    }
    return countUp - countDown

}