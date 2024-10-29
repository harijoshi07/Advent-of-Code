package aoc2015

import java.io.File

fun main() {
    val input = File("src/aoc2015/input02.txt").readLines()
    calculateArea(input)
}

fun calculateArea(input: List<String>) {
    var total = 0

    input.forEach { data ->
        // Parse dimensions
        val digitList = data.split("x").map { it.toInt() }
        val (l, w, h) = digitList

        // Calculate the surface area
        val surfaceArea = 2 * l * w + 2 * w * h + 2 * h * l

        // Calculate the smallest side area
        val sideAreas = listOf(l * w, w * h, h * l)
        val extraSum = sideAreas.minOrNull() ?: 0

        // Calculate the total wrapping paper needed for this box
        val totalForBox = surfaceArea + extraSum
        total += totalForBox
    }

    println(total)
}
