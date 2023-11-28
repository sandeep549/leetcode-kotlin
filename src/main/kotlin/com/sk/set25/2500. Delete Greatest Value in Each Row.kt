package com.sk.set25

class Solution {

    // Time: O(C*R*R)
    // Space: O(R)
    fun deleteGreatestValue(grid: Array<IntArray>): Int {
        var c = 0
        var ans = 0
        while (c < grid[0].size) {
            val list = mutableListOf<Int>()
            for (r in grid.indices) {
                val i = max(grid, r)
                list.add(grid[r][i])
                grid[r][i] = 0
            }
            ans += list.max()
            c++
        }
        return ans
    }

    fun max(grid: Array<IntArray>, row: Int): Int {
        val arr = grid[row]
        var max = 0
        for (i in 1..arr.lastIndex) {
            if (arr[i] > arr[max]) max = i
        }
        return max
    }

    // Time: O(R * C*logC) + O(R*C)
    // Space: O(1)
    fun deleteGreatestValue2(grid: Array<IntArray>): Int {
        for (i in grid.indices) {
            grid[i].sort()
        }
        var ans = 0
        for (c in grid[0].indices.reversed()) {
            var max = 0
            for (r in grid.indices) {
                if (grid[r][c] > max) max = grid[r][c]
            }
            ans += max
        }
        return ans
    }
}