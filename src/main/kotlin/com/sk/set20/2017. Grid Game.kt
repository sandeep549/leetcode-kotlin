package com.sk.set20

class Solution2017 {
    fun gridGame(grid: Array<IntArray>): Long {
        var topSum = grid[0].sumOf { it.toLong() } // Sum of the top row
        var bottomSum = 0L // Initially, bottom row sum is 0
        var ans = Long.MAX_VALUE

        for (i in grid[0].indices) {
            topSum -= grid[0][i] // Reduce the points from the top row
            ans = minOf(ans, maxOf(topSum, bottomSum)) // Minimize the maximum points for the second robot
            bottomSum += grid[1][i] // Add points from the bottom row
        }

        return ans
    }
}