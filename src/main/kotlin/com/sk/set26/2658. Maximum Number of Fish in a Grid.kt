package com.sk.set26

class Solution2658 {
    fun findMaxFish(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val directions = listOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))
        var maxFish = 0

        // Iterate through all cells in the grid
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] > 0) { // Start from a water cell
                    // Calculate the total fish for this component
                    maxFish = maxOf(maxFish, dfs(r, c, rows, cols, directions, grid))
                }
            }
        }

        return maxFish
    }

    private fun dfs(
        r: Int,
        c: Int,
        rows: Int,
        cols: Int,
        directions: List<Pair<Int, Int>>,
        grid: Array<IntArray>
    ): Int {
        // If the cell is out of bounds or not a water cell, return 0
        if (r !in 0 until rows || c !in 0 until cols || grid[r][c] == 0) return 0

        // Catch all fish in the current cell and mark it as visited
        val fish = grid[r][c]
        grid[r][c] = 0

        // Explore all adjacent cells
        var totalFish = fish
        for ((dr, dc) in directions) {
            totalFish += dfs(r + dr, c + dc, rows, cols, directions, grid)
        }
        return totalFish
    }

}