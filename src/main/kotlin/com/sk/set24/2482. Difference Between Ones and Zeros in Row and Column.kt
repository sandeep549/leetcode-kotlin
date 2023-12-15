package com.sk.set24

class Solution2482 {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val oneRow = IntArray(grid.size) { 0 }
        val oneCol = IntArray(grid[0].size) { 0 }
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                oneRow[r] += if (grid[r][c] == 1) 1 else 0
                oneCol[c] += if (grid[r][c] == 1) 1 else 0
            }
        }

        val mat = Array(grid.size) { IntArray(grid[0].size) { 0 } }
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                mat[r][c] = oneRow[r] + oneCol[c] - (grid.size - oneRow[r]) - (grid[0].size - oneCol[c])
            }
        }

        return mat
    }
}