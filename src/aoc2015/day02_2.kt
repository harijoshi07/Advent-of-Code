package aoc2015

import java.io.File

fun main() {

    val input = File("src/aoc2015/input02.txt").readLines()
    calculateTotalRibbonRequired(input)

}

fun calculateTotalRibbonRequired(input: List<String>) {

    var sum = 0

    input.forEach {
        val list = it.split("x").map { it.toInt() }
        val length = list[0]
        val breadth = list[1]
        val height = list[2]

        //Calculate the perimeter of each side
        val perimeter: List<Int> = listOf(2 * length, 2 * breadth, 2 * height)

        var smallestPerimeter = 0

        //find smallest perimeter
        if (perimeter[0] >= perimeter[1] && perimeter[0] >= perimeter[2]) {
            smallestPerimeter = perimeter[1] + perimeter[2]
        } else if (perimeter[1] >= perimeter[2] && perimeter[1] >= perimeter[0]) {
            smallestPerimeter = perimeter[0] + perimeter[2]
        } else if (perimeter[2] >= perimeter[1] && perimeter[2] >= perimeter[0]) {
            smallestPerimeter = perimeter[0] + perimeter[1]
        }

        //calculate ribbon amount for bow
        val bowAmount = length * breadth * height

        sum += bowAmount + smallestPerimeter
    }
    println(sum)

}