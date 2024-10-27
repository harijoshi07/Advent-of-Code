package aoc2015

import java.io.File

fun main() {
    val input = File("src/aoc2015/input01.txt").readText()
    val output = calcNoOfFloors(input)
    println(output)
    betterMethod(input)

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

fun betterMethod(input: String) {
    val output = input.sumOf { if (it == '(') 1 else -1 as Int }
    println(output)
}