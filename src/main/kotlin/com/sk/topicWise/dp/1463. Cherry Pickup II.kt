package com.sk.topicWise.dp

class Solution1463 {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m) { Array(n) { IntArray(n){-1} }}
        return dfs(grid, m, n, 0, 0, n - 1, dp)
    }

    fun dfs(grid: Array<IntArray>, m: Int, n: Int, r: Int, c1: Int, c2: Int, dp: Array<Array<IntArray>>): Int {
        if (r == m) return 0 // Reach to bottom row
        if (dp[r][c1][c2] != -1) return dp[r][c1][c2]
        var ans = 0
        for (i in -1..1) {
            for (j in -1..1) {
                val nc1 = c1 + i
                val nc2 = c2 + j
                if (nc1 >= 0 && nc1 < n && nc2 >= 0 && nc2 < n) {
                    ans = Math.max(ans, dfs(grid, m, n, r + 1, nc1, nc2, dp))
                }
            }
        }
        val cherries = if (c1 == c2) grid[r][c1] else grid[r][c1] + grid[r][c2]
        return ans + cherries.also { dp[r][c1][c2] = it }
    }

}