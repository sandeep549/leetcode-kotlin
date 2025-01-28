package com.sk.set6

class Solution695 {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val directions = listOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))
        var maxCount = 0

        // Iterate through all cells in the grid
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] > 0) { // Start from a water cell
                    maxCount = maxOf(maxCount, dfs(r, c, rows, cols, directions, grid))
                }
            }
        }

        return maxCount
    }

    private fun dfs(
        r: Int,
        c: Int,
        rows: Int,
        cols: Int,
        directions: List<Pair<Int, Int>>,
        grid: Array<IntArray>
    ): Int {
        if (r !in 0 until rows || c !in 0 until cols || grid[r][c] == 0) return 0

        val count = grid[r][c]
        grid[r][c] = 0

        // Explore all adjacent cells
        var totalCount = count
        for ((dr, dc) in directions) {
            totalCount += dfs(r + dr, c + dc, rows, cols, directions, grid)
        }
        return totalCount
    }
}