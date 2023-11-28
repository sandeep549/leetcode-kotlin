package com.sk.set17

class Solution1727 {
    fun largestSubmatrix(matrix: Array<IntArray>): Int {
        var ans = 0
        val height = IntArray(matrix[0].size)

        for (r in matrix.indices) {
            for (c in matrix[0].indices) {
                if (matrix[r][c] == 0) height[c] = 0
                else height[c] += 1
            }

            val arr = height.sorted()

            for (c in matrix[0].indices) {
                ans = maxOf(ans, arr[c] * (matrix[0].size - c))
            }
        }

        return ans
    }
}