package com.sk.set0

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

class Solution64 {
    fun minPathSum(grid: Array<IntArray>): Int {
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

    fun minPathSum2(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val max = 200 * (m + n - 1)
        val dp = Array(m) { IntArray(n) { max } }
        dp[0][0] = grid[0][0]
        fun min(r: Int, c: Int): Int {
            if (r !in grid.indices || c !in grid[0].indices) return 200
            return dp[r][c]
        }

        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (r == 0 && c == 0) continue
                dp[r][c] = minOf(min(r - 1, c), min(r, c - 1)) + grid[r][c]
            }
        }

        return dp[m - 1][n - 1]
    }
}