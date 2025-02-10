package com.sk.set31

class Solution3160 {
    fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
        val result = IntArray(queries.size)
        val ballColors = mutableMapOf<Int, Int>()  // Stores the color of each ball
        val colorCount = mutableMapOf<Int, Int>()  // Stores frequency of each color
        var distinctColors = 0

        for ((i, query) in queries.withIndex()) {
            val (ball, color) = query

            // Check if the ball was previously colored
            if (ball in ballColors) {
                val prevColor = ballColors[ball]!!

                // Reduce the count of the previous color
                colorCount[prevColor] = colorCount[prevColor]!! - 1
                if (colorCount[prevColor] == 0) {
                    colorCount.remove(prevColor)
                    distinctColors--
                }
            }

            // Assign the new color
            ballColors[ball] = color
            colorCount[color] = colorCount.getOrDefault(color, 0) + 1

            // If this is a new color, increase distinct color count
            if (colorCount[color] == 1) {
                distinctColors++
            }

            result[i] = distinctColors
        }

        return result
    }

}