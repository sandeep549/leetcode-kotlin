package com.sk

import kotlin.math.min

private fun minPathSum2(grid: Array<IntArray>): Int {
    val r = grid.size
    val c = grid[0].size
    for (i in 1 until c) {
        grid[0][i] += grid[0][i - 1]
    }
    for (i in 1 until r) {
        grid[i][0] += grid[i - 1][0]
    }
    for (i in 1 until r) {
        for (j in 1 until c) {
            grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])
        }
    }
    return grid[r - 1][c - 1]
}