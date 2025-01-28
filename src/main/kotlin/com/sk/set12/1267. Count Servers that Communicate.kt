package com.sk.set12

class Solution1267 {
    fun countServers(grid: Array<IntArray>): Int {
        val R = grid.size
        val C = grid[0].size
        val colCount = IntArray(C)
        val rowCount = IntArray(R)

        // Count the number of servers in each row and column
        for (r in 0 until R) {
            for (c in 0 until C) {
                if (grid[r][c] == 1) {
                    rowCount[r]++
                    colCount[c]++
                }
            }
        }

        var totalServers = 0

        // Count the servers that can communicate
        for (r in 0 until R) {
            for (c in 0 until C) {
                if (grid[r][c] == 1 && (rowCount[r] > 1 || colCount[c] > 1)) {
                    totalServers++
                }
            }
        }

        return totalServers
    }
}