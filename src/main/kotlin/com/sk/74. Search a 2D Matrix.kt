package com.sk

class Solution64 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val R = matrix.size
        val C = matrix[0].size
        var l = 0
        var r = R * C - 1
        while (l < r) {
            val m = (l + r) / 2
            if (target > matrix[m / C][m % C]) {
                l = m + 1
            } else {
                r = m
            }
        }
        return matrix[l / C][l % C] == target
    }
}